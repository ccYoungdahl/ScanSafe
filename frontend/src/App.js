import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

import ScanScreen from "./Screens/ScanScreen";
import ResultScreen from "./Screens/ResultScreen";
import YourIngredientsScreen from "./Screens/YourIngredientsScreen";
import InfluencerDashboard from "./Screens/InfluencerDashboard";
import AlternativeProductForm from "./Screens/AlternativeProductForm";
import ProposedIngredientForm from './Screens/ProposedIngredientForm';
import UpdateAlternativeProduct from './Screens/UpdateAlternativeProduct';
import UpdateProposedIngredient from './Screens/UpdateProposedIngredient';

import Navbar from "./components/Navbar";

function App() {
  return (
    <Router>
      <Navbar />
      <Routes>
        <Route path="/" element={<ScanScreen />} />
        <Route path="product">
          <Route path=":upc" element={<ResultScreen />} />
        </Route>
              <Route path="/your-ingredients" element={<YourIngredientsScreen />} />
              <Route path="InfluencerDashboard" element={<InfluencerDashboard />} />
              <Route path="AlternativeProductForm" element={<AlternativeProductForm />} />
              <Route path="ProposedIngredientForm" element={<ProposedIngredientForm />} />
              <Route path="UpdateAlternativeProduct/:id" element={<UpdateAlternativeProduct />} />
              <Route path="UpdateProposedIngredient/:id" element={<UpdateProposedIngredient />} />
      </Routes>
    </Router>
  );
}

export default App;
