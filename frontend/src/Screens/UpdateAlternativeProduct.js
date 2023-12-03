import React, { useEffect, useState } from "react";
import { useNavigate, useParams } from 'react-router-dom';
import InfluencerService from "../Services/InfluencerService";

const UpdateAlternativeProduct = () => {

    const { id } = useParams();
    const navigate = useNavigate();

    const [alternativeProduct, setAlternativeProduct] = useState({
        id: id,
        altProduct: "",
        replacesProduct: "",
        upc: "",
        notes: ""
    });

    const handleChange = (e) => {
        const value = e.target.value;
        setAlternativeProduct({ ...alternativeProduct, [e.target.name]: value });
    };

    useEffect(() => {
        const fetchData = async () => {
            try {
                const response = await InfluencerService.getAlternativeProductById(id);
                setAlternativeProduct(response.data);
            } catch (error) {
                console.log(error);
            }
        };

        fetchData();
    }, []);

    const updateAlternativeProduct = (e) => {
        e.preventDefault();
        InfluencerService.updateAlternativeProduct(alternativeProduct, id).then((response) => {
        }).catch((error) => {
            console.log(error);
        });
        navigate("/InfluencerDashboard");
    };

    return (
        <div className="container pt-5">

            <h1 className="mb-4">Update your suggestion:</h1>
 
            <div className="bg-light-subtle p-4">

                <form>

                    <div className="mb-3">
                        <div className="form-group">
                            <label for="replacesProduct" className="form-label">Product name</label>
                            <input type="text" name="replacesProduct" className="form-control"
                                value={alternativeProduct.replacesProduct} onChange={(e) => handleChange(e)} />
                        </div>
                    </div>

                    <div className="mb-3">
                        <div className="form-group">
                            <label for="upc" className="form-label">Barcode number</label>
                            <input type="text" name="upc" className="form-control"
                                value={alternativeProduct.upc} onChange={(e) => handleChange(e)} />
                        </div>
                    </div>

                    <div className="mb-3">
                        <div className="form-group">
                            <label for="altProduct" className="form-label">Healthy alternative</label>
                            <input type="text" name="altProduct" className="form-control"
                                value={alternativeProduct.altProduct} onChange={(e) => handleChange(e)} />
                        </div>
                    </div>

                    <div className="mb-3">
                        <div className="form-group">
                            <label for="notes" className="form-label">Update your thoughts on these awesome alternatives!</label>
                            <textarea name="notes" className="form-control" rows="5"
                                value={alternativeProduct.notes} onChange={(e) => handleChange(e)} />
                        </div>
                    </div>

                    <div className="row mb-3">
                        <label for="ingredient" className="col-sm-2 col-form-label"></label>
                        <div className="col-sm-10">
                            <button type="button" onClick={() => navigate("/InfluencerDashboard")} className="btn btn-light" style={{ float: 'right' }}>Cancel</button>
                            <button className="btn btn-success" onClick={updateAlternativeProduct} style={{ float: 'right' }} >Update</button>
                        </div>
                    </div>

                </form>
            </div>

        </div>

    )
}
export default UpdateAlternativeProduct;