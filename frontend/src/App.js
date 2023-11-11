import { BrowserRouter as Router, Route, Routes } from "react-router-dom";

import ScanScreen from "./Screens/ScanScreen";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<ScanScreen />} />
      </Routes>
    </Router>
  );
}

export default App;
