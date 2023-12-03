import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import InfluencerService from '../Services/InfluencerService'

const InfluencerDashboard = () => {

    const navigate = useNavigate();

    const [loading, setLoading] = useState(true);
    const [alternativeProducts, setAlternativeProducts] = useState([]);
    const [proposedIngredients, setProposedIngredients] = useState([]);

    useEffect(() => {
        const fetchData = async () => {
            setLoading(true);
            try {
                const response = await InfluencerService.getAlternativeProducts();
                const response2 = await InfluencerService.getProposedIngredients();
                setAlternativeProducts(response.data);
                setProposedIngredients(response2.data);
            } catch (error) {
                console.log(error);
            }
            setLoading(false);
        };

        fetchData();    
    }, []);

    const deleteAlternativeProduct = (e, id) => {
        e.preventDefault();
        InfluencerService.deleteAlternativeProduct(id).then((response) => {
            if (alternativeProducts) {
                setAlternativeProducts((prevElement) => {
                    return prevElement.filter((alternativeProduct) => alternativeProduct.id !== id);
                });
            }
        });
    };

    const deleteProposedIngredient = (e, id) => {
        e.preventDefault();
        InfluencerService.deleteProposedIngredient(id).then((response) => {
            if (proposedIngredients) {
                setProposedIngredients((prevElement) => {
                    return prevElement.filter((proposedIngredient) => proposedIngredient.id !== id);
                })
            }
        })

    };

    const editAlternativeProduct = (e, id) => {
        e.preventDefault();
        navigate('/UpdateAlternativeProduct/' + id);
    };

    const editProposedIngredient = (e, id) => {
        e.preventDefault();
        navigate('/UpdateProposedIngredient/' + id)
    };

    return (
        <div className="container pt-5">
            <h1 className="mb-4">Hello, influencer!</h1>
            <br></br>
            <br></br>

            <table className="table table-hover">
                <thead>
                    <tr>
                        <th colspan='3'><h5>Your suggestion list:</h5></th>
                        <th style={{ textAlign: 'right' }}><a href='AlternativeProductForm'><button type="button" className="btn btn-success">Create new</button></a></th>
                    </tr>
                </thead>
                {!loading && (
                    <tbody>
                        {alternativeProducts.map((alternativeProduct) => (
                            <tr key={alternativeProduct.id}>
                                <td>{alternativeProduct.altProduct}</td>
                                <td>replaces</td>
                                <td>{alternativeProduct.replacesProduct}</td>
                                <td style={{ textAlign: 'right' }}>
                                    <button type="button" onClick={(e, id) => editAlternativeProduct(e, alternativeProduct.id)} className="btn btn-light" style={{ marginRight: '10px' }}>Edit</button>
                                    
                                    <button type="button" onClick={(e, id) => deleteAlternativeProduct(e, alternativeProduct.id)} className="btn btn-outline-danger" style={{ float: 'right' }}>Delete</button>

                                </td>
                            </tr>
                        ))}
                </tbody>
                )}
            </table>

            <br></br>
            <br></br>
            <br></br>
            <br></br>

            <table className="table table-hover">
                <thead>
                    <tr>
                        <th colspan='3'><h5>Your ingredient watchlist proposals:</h5></th>
                        <th style={{ textAlign: 'right' }}><a href='ProposedIngredientForm'><button type="button" className="btn btn-success">Create new</button></a></th>
                    </tr>
                    <tr>
                        <th>Ingredient</th>
                        <th>Risk</th>
                        <th>Status</th>
                        <th></th>
                    </tr>
                </thead>
                {!loading && (
                    <tbody>
                        {proposedIngredients.map((proposedIngredient) => (
                       <tr key={proposedIngredient.id}>
                            <td>{proposedIngredient.name}</td>
                            <td>{proposedIngredient.risk}</td>
                            {(() => {
                                if (proposedIngredient.approved) { return <td>Approved</td> }
                                else if (proposedIngredient.rejected) { return <td>Rejected</td> }
                                else { return <td>Pending</td> }
                                })()}
                                <td style={{ textAlign: 'right' }}>
                                <button type="button" onClick={(e, id) => editProposedIngredient(e, proposedIngredient.id)} className="btn btn-light" style={{ marginRight: '10px' }}>Edit</button>
                                <button type="button" onClick={(e, id) => deleteProposedIngredient(e, proposedIngredient.id)} className="btn btn-outline-danger" style={{ float: 'right' }}>Delete</button>
                             </td>
                       </tr>
                ))}
            </tbody>
            )}
        </table>

    </div>
    
    );
};

/*
class InfluencerDashboard extends Component {

    constructor(props) {
        super(props)

        this.state = {
            proposedIngredients: [],
            alternativeProducts: []
        }
        this.addAlternativeProduct = this.addAlternativeProduct.bind(this);
    }

    componentDidMount() {
        InfluencerService.getProposedIngredients().then((response) => {
            this.setState({ proposedIngredients: response.data });
        });
        InfluencerService.getAlternativeProducts().then((response) => {
            this.setState({ alternativeProducts: response.data });
        });
    }

    addAlternativeProduct() {
        this.props.history.push('AlternativeProductForm');
    }

    render() {
        return (
            <div className="container pt-5">
                <h1 className="mb-4">Hello, influencer!</h1>
                    <br></br>
                    <br></br>

                 <table className="table table-hover">
                    <thead>
                    <tr>
                            <th colspan='3'><h5>Your suggestion list:</h5></th>
                            <th style={{ textAlign: 'right' }}><a href='AlternativeProductForm'><button type="button" class="btn btn-success">Create new</button></a></th>
                    </tr>
                    </thead>

                    <tbody> { 
                        this.state.alternativeProducts.map(
                            alternativeProduct =>
                                <tr key={alternativeProduct.id}>
                                    <td>{alternativeProduct.altProduct}</td>                          
                                    <td>replaces</td>
                                    <td>{alternativeProduct.replacesProduct}</td>

                                    <td style={{ textAlign: 'right' }} ><a href="@{/showFormForUpdate/id={id}(id=${alternativeProduct.id})}" className="btn btn-light" style={{ marginRight: '10px' }}>Edit</a>
                       
                        
                        
                        
                                <button type="button" className="btn btn-outline-danger" data-bs-toggle="modal" attr="data-bs-target='#staticBackdrop' + *{alternativeProduct.id}" style={{ float: 'right' }}>Delete</button>
                     
                        <div className="modal fade" id="*{'staticBackdrop' + {alternativeProduct.id}}" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                          <div className="modal-dialog">
                            <div className="modal-content">
                              <div className="modal-header">
                                <h1 className="modal-title fs-5" id="staticBackdropLabel">Delete suggestion?</h1>
                                <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                              </div>
                              <div className="modal-body">
                                Are you sure you want to delete this suggestion?
                              </div>
                              <div className="modal-footer">
                                <button type="button" className="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                                <a href="@{/deleteAlternativeProduct/id={id}(id=${alternativeProduct.id})}"  className="btn btn-outline-danger">Delete</a>
                              </div>
                            </div>
                          </div>
                        </div> 
                    </td>  
                </tr>
                )
                }
            </tbody>
        </table>
            
            <br></br>
            <br></br>
            <br></br>
            <br></br>

                    <table className="table table-hover">
                        <thead>
                            <tr>
                            <th colspan='3'><h5>Your ingredient watchlist proposals:</h5></th>
                            <th style={{ textAlign: 'right' }}><a href='ProposedIngredientForm'><button type="button" className="btn btn-success">Create new</button></a></th>
                            </tr>
                            <tr>
                                <th>Ingredient</th>
                                <th>Risk</th>
                                <th>Status</th>
                                <th></th>
                            </tr>
                        </thead>

                        <tbody> {
                            this.state.proposedIngredients.map(
                                proposedIngredient =>
                                    <tr key={proposedIngredient.id}>
                                        <td>{proposedIngredient.name}</td>
                                        <td>{proposedIngredient.risk}</td>
                                        {(() => {
                                            if (proposedIngredient.approved) { return <td>Approved</td> }
                                            else if (proposedIngredient.rejected) { return <td>Rejected</td> }
                                            else { return <td>Pending</td> }
                                        })()}
                                        <td style={{ textAlign: 'right' }}><a href="@{/showFormForPropUpdate/id={id}(id=${proposedIngredient.id})}" className="btn btn-light" style={{ marginRight: '10px' }}>Edit</a>

                                            <button type="button" className="btn btn-outline-danger" data-bs-toggle="modal" attr="data-bs-target='#staticBackdrop' + *{proposedIngredient.id}" style={{ float: 'right' }} >Delete</button>

                                            <div className="modal fade" id="*{'staticBackdrop' + {proposedIngredient.id}}" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1" aria-labelledby="staticBackdropLabel" aria-hidden="true">
                                                <div className="modal-dialog">
                                                    <div className="modal-content">
                                                        <div className="modal-header">
                                                            <h1 className="modal-title fs-5" id="staticBackdropLabel">Delete proposal?</h1>
                                                            <button type="button" className="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                        </div>
                                                        <div className="modal-body">
                                                            Are you sure you want to delete this ingredient proposal?
                                                        </div>
                                                        <div className="modal-footer">
                                                            <button type="button" className="btn btn-secondary" data-bs-dismiss="modal">Cancel</button>
                                                            <a href="@{/deleteProposedIngredient/id={id}(id=${proposedIngredient.id})}" className="btn btn-outline-danger">Delete</a>
                                                        </div>
                                                    </div>
                                                </div>
                                            </div>

                                        </td>
                                    </tr>
                            )
                        }
                        </tbody>

                    </table>

                </div>


        )

    }
}
*/
export default InfluencerDashboard;