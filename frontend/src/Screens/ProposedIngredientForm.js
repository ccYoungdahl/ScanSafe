import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import InfluencerService from '../Services/InfluencerService';

const ProposedIngredientForm = () => {

    const navigate = useNavigate();

    const [proposedIngredient, setProposedIngredient] = useState({
        name: "",
        risk: "",
        website: "",
        comments: "",
    });

    const handleChange = (e) => {
        const value = e.target.value;
        setProposedIngredient({ ...proposedIngredient, [e.target.name]: value });
    };

    const saveProposedIngredient = (e) => {
        e.preventDefault();
        InfluencerService.saveProposedIngredient(proposedIngredient).then((response) => {
        }).catch((error) => {
            console.log(error);
        });
        navigate('/InfluencerDashboard');
    };

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
                                    value={proposedIngredient.name} onChange={(e) => handleChange(e)} />
                                <span className="input-group-text" id="basic-addon2">check</span>
                            </div>
                        </div>
                    </div>

                    <div className="mb-3">
                        <div className="form-group">
                            <label for="risks" className="form-label">Risks to humans</label>
                            <input type="text" name="risk" className="form-control" placeholder="It may damage DNA"
                                value={proposedIngredient.risk} onChange={(e) => handleChange(e)} />
                        </div>
                    </div>

                    <div className="mb-3">
                        <div className="form-group">
                            <label for="basic-url" className="form-label">Supporting website</label>
                            <div className="input-group">
                                <span className="input-group-text" id="supportingWebsite">https://</span>
                                <input type="text" name="website" className="form-control" aria-describedby="basic-addon3 basic-addon4"
                                    value={proposedIngredient.website} onChange={(e) => handleChange(e)} />
                            </div>
                            <div className="form-text" id="basic-addon4">Any reputable site that provides documentation to support your proposal</div>
                        </div>
                    </div>

                    <div className="mb-3">
                        <div className="form-group">
                            <label for="comments" className="form-label">Comments</label>
                            <textarea className="form-control" name="comments" rows="5"
                                value={proposedIngredient.comments} onChange={(e) => handleChange(e)} />
                        </div>
                    </div>

                    <div className="row mb-3">
                        <label for="ingredient" className="col-sm-2 col-form-label"></label>
                        <div className="col-sm-10">
                            <a href='InfluencerDashboard'><button type="button" className="btn btn-light" style={{ float: 'right' }} >Cancel</button></a>
                            <button type="submit" className="btn btn-success" onClick={saveProposedIngredient} style={{ float: 'right' }} >Submit</button>
                        </div>
                    </div>

                </form>
            </div>
        </div>

    );
}
export default ProposedIngredientForm;