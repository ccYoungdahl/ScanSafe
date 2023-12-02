import { Component } from "react";
import InfluencerService from "../Services/InfluencerService";

class ProposedIngredientForm extends Component {
    constructor(props) {
        super(props)

        this.state = {

            userId: '',
            name: '',
            risk: '',
            website: '',
            comments: '',
            approved: '0',
            rejected: '0'
        }
        this.changeNameHandler = this.changeNameHandler.bind(this);
        this.changeRiskHandler = this.changeRiskHandler.bind(this);
        this.changeWebsiteHandler = this.changeWebsiteHandler.bind(this);
        this.changeCommentsHandler = this.changeCommentsHandler.bind(this);
        this.savePropIngredient = this.savePropIngredient.bind(this);
    }

    savePropIngredient = (e) => {
        e.preventDefault();
        let proposedIngredient = { name: this.state.name, risk: this.risk, website: this.state.website, comments: this.state.comments };
        console.log('proposedIngredient => ' + JSON.stringify(proposedIngredient));

        InfluencerService.saveProposedIngredient(proposedIngredient);
        this.props.history.push('/InfluencerDashboard');
    }


    changeNameHandler = (event) => {
        this.setState({ name: event.target.value });
    }

    changeRiskHandler = (event) => {
        this.setState({ risk: event.target.value });
    }

    changeWebsiteHandler = (event) => {
        this.setState({ website: event.target.value });
    }

    changeCommentsHandler = (event) => {
        this.setState({ comments: event.target.value });
    }


    render() {
        return (

            <div className="container pt-5">
                <h1 className="mb-4">New ingredient or additive proposal form</h1>
                <div className="bg-light-subtle p-4">

                    <form>

                        <div className="mb-3">
                            <div className="form-group">
                                <label for="ingredientName" className="form-label">Ingredient</label>
                                <div className="input-group">

                                    <input type="text" name="name" className="form-control" placeholder="Titanium dioxide, red 40, etc."
                                        value={this.state.name} onChange={this.changeNameHandler} />
                                        <span className="input-group-text" id="basic-addon2">check</span>
                                </div>
                            </div>
                        </div>

                        <div className="mb-3">
                            <div className="form-group">
                                <label for="risks" className="form-label">Risks to humans</label>
                                <input type="text" name="risk" className="form-control" placeholder="It may damage DNA"
                                    value={this.state.risk} onChange={this.changeRiskHandler} />
                            </div>
                        </div>

                        <div className="mb-3">
                            <div className="form-group">
                                <label for="basic-url" className="form-label">Supporting website</label>
                                <div className="input-group">
                                    <span className="input-group-text" id="supportingWebsite">https://</span>
                                    <input type="text" name="website" className="form-control" aria-describedby="basic-addon3 basic-addon4"
                                        value={this.website} onChange={this.changeWebsiteHandler} />
                                </div>
                                <div className="form-text" id="basic-addon4">Any reputable site that provides documentation to support your proposal</div>
                            </div>
                        </div>

                        <div className="mb-3">
                            <div className="form-group">
                                <label for="comments" className="form-label">Comments</label>
                                <textarea className="form-control" name="comments" rows="5"
                                    value={this.comments} onChange={this.changeCommentsHandler} />
                            </div>
                        </div>

                        <div className="row mb-3">
                            <label for="ingredient" className="col-sm-2 col-form-label"></label>
                            <div className="col-sm-10">
                                <a href='influencerDashboard'><button type="button" className="btn btn-light" style={{ float: 'right' }} >Cancel</button></a>
                                <button type="submit" className="btn btn-success" onClick={this.savePropIngredient} style={{ float: 'right' }} >Submit</button>
                            </div>
                        </div>

                    </form>
                </div>
            </div>

        )
    }
}
export default ProposedIngredientForm