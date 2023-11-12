import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

import ScanScreen from "./Screens/ScanScreen";
import ResultScreen from "./Screens/ResultScreen";

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
      </Routes>
    </Router>
  );
}

export default App;
