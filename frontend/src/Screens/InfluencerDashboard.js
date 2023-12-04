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

export default InfluencerDashboard;