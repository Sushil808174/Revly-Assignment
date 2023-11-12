
import { BrowserRouter } from 'react-router-dom';
import './App.css';
import Navbar from './components/Navbar';
import AllRouter from './components/AllRouter';


function App() {
  return (
    <BrowserRouter>
      
      <div className="App">
        <Navbar />
        <AllRouter />
      </div>
    </BrowserRouter>
  );
}

export default App;
