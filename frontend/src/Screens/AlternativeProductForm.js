import React, { Component } from "react";
import InfluencerService from "../Services/InfluencerService";
class AlternativeProductForm extends Component {
            
    constructor(props) {
        super(props)

        this.state = {

            altProduct: '',
            replacesProduct: '',
            upc: '',
            notes: ''

        }
        this.changeReplacesProductHandler = this.changeReplacesProductHandler.bind(this);
        this.changeUpcHandler = this.changeUpcHandler.bind(this);
        this.changeAltProductHandler = this.changeAltProductHandler.bind(this);
        this.changeNotesHandler = this.changeNotesHandler.bind(this);
        this.saveAltProduct = this.saveAltProduct.bind(this);

    }

    
    saveAltProduct = (e) => {
        e.preventDefault();
        let alternativeProduct = { altProduct: this.state.altProduct, replacesProduct: this.state.replacesProduct, upc: this.state.upc, notes: this.state.notes };
        console.log('alternativeProduct => ' + JSON.stringify(alternativeProduct));

        InfluencerService.saveAlternativeProduct(alternativeProduct);
        this.props.history.push('/InfluencerDashboard');
    }


    changeReplacesProductHandler = (event) => {
        this.setState({ replacesProduct: event.target.value });
    }

    changeUpcHandler = (event) => {
        this.setState({ upc: event.target.value });
    }

    changeAltProductHandler = (event) => {
        this.setState({altProduct: event.target.value});
    }

    changeNotesHandler = (event) => {
        this.setState({ notes: event.target.value });
    }

    render() {
        return (
            <div className="container pt-5">

                <h1 className="mb-4">Suggest a replacement item:</h1>
                <p>Help your fellow ScanSafe users out by suggesting your favorite alternative for products with harmful ingredients!</p>

                <div className="bg-light-subtle p-4">

                    <form>

                        <div className="mb-3">
                            <div className="form-group">
                                <label for="replacesProduct" className="form-label">Product name</label>
                                <input type="text" name="replacesProduct" className="form-control" placeholder="Doritos, Hawaiian Punch, etc."
                                    value={this.state.replacesProduct} onChange={this.changeReplacesProductHandler}/>
                            </div>
                        </div>

                        <div className="mb-3">
                            <div className="form-group">
                                <label for="upc" className="form-label">Barcode number</label>
                                <input type="text" name="upc" className="form-control" placeholder=""
                                    value={this.state.upc} onChange={this.changeUpcHandler} />
                            </div>
                        </div>

                        <div className="mb-3">
                            <div className="form-group">
                                <label for="altProduct" className="form-label">Healthy alternative</label>
                                <input type="text" name="altProduct" className="form-control" placeholder="Beanfields Nacho Bean Chips"
                                    value={this.state.altProduct} onChange={this.changeAltProductHandler}/>
                            </div>
                        </div>

                        <div className="mb-3">
                            <div className="form-group">
                                <label for="notes" className="form-label">Share your thoughts on these awesome alternatives!</label>
                                <textarea name="notes" className="form-control" rows="5"
                                    value={this.state.notes} onChange={this.changeNotesHandler}/>
                            </div>
                        </div>

                        <div className="row mb-3">
                            <label for="ingredient" className="col-sm-2 col-form-label"></label>
                            <div className="col-sm-10">
                                <a href='InfluencerDashboard'><button type="button" className="btn btn-light" style={{ float: 'right' }}>Cancel</button></a>
                                <button className="btn btn-success" onClick={this.saveAltProduct} style={{ float: 'right' }} >Submit</button>
                            </div>
                        </div>

                    </form>
                </div>

            </div>
        
        )
    }
}

export default AlternativeProductForm