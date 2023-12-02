import React from 'react';
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

import ScanScreen from "./Screens/ScanScreen";
import ResultScreen from "./Screens/ResultScreen";
import InfluencerDashboard from "./Screens/InfluencerDashboard";
import AlternativeProductForm from "./Screens/AlternativeProductForm";
import ProposedIngredientForm from './Screens/ProposedIngredientForm';

import Navbar from "./components/Navbar";
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";


function App() {
    return (
     
    <Router>
        <Navbar />
            <Routes>
                <Route path="/" element={<ScanScreen />} />
                <Route path="product">
                <Route path=":upc" element={<ResultScreen />} />
                </Route>
                <Route path="InfluencerDashboard" element={<InfluencerDashboard />} />
                <Route path="AlternativeProductForm" element={<AlternativeProductForm />} />
                <Route path="ProposedIngredientForm" element={<ProposedIngredientForm />} />
            </Routes>
    </Router>

  );
}

export default App;
