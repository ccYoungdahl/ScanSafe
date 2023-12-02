import axios from 'axios';

const PROPOSED_INGREDIENT_API_BASE_URL = "http://localhost:8080/getProposedIngredients";
const SAVE_PROPOSED_INGREDIENT_API_BASE_URL = "http://localhost:8080/saveProposedIngredient";

const ALTERNATIVE_PRODUCT_API_BASE_URL = "http://localhost:8080/getAlternativeProducts";
const SAVE_ALTERNATIVE_PRODUCT_API_BASE_URL = "http://localhost:8080/saveAlternativeProduct";
class InfluencerService {

    getProposedIngredients() {
        return axios.get(PROPOSED_INGREDIENT_API_BASE_URL);
    }

    saveProposedIngredient(proposedIngredient) {
        return axios.post(SAVE_PROPOSED_INGREDIENT_API_BASE_URL, proposedIngredient);
    }

    getAlternativeProducts() {
        return axios.get(ALTERNATIVE_PRODUCT_API_BASE_URL);
    }

    saveAlternativeProduct(alternativeProduct) {
        return axios.post(SAVE_ALTERNATIVE_PRODUCT_API_BASE_URL, alternativeProduct);
    }
}

export default new InfluencerService();