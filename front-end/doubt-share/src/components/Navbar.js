import React, { useEffect, useState } from 'react';
import { Link } from 'react-router-dom';

const Navbar = () => {

  const [activeTutors, setActiveTutors] = useState();

  useEffect(() => {
   
    fetch('http://localhost:8888/all-available-tutor')
      .then((response) => response.json())
      .then((data) => setActiveTutors(data))
      .catch((error) => console.error('Error fetching doubts:', error));
   }, []);


  return (
    <nav className="navbar navbar-expand-lg shadow p-2">
      <Link className="navbar-brand fs-4" to={"/"}><b>DoubtShare</b></Link>
      <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span className="navbar-toggler-icon"></span>
      </button>
      <div className="collapse navbar-collapse" id="navbarNav">
        <ul className="navbar-nav ml-auto">
          <li className="nav-item m-1">
            <Link className="nav-link fs-5" to={"/doubt-history"}>Doubt History</Link> 
          </li>
         
          <li className="nav-item m-1">
            <Link className="nav-link fs-5" to={"/create-doubt"}>Ask Doubt</Link> 
          </li>
          
          <li className='nav-item m-1'>
              <Link className="nav-link fs-5" to={"/active-tutor"}>Active Tutors
              {activeTutors ? <span className='position-relative'>
              <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
    {activeTutors}
    <span class="visually-hidden">unread messages</span>
              </span></span> : <span className='position-relative'>
              <span class="position-absolute top-0 start-100 translate-middle badge rounded-pill bg-danger">
    {0}
    <span class="visually-hidden">unread messages</span>
              </span></span>}
              </Link>
          </li>

          <li className="nav-item m-1">
            <Link className="nav-link fs-5" to={"/profile"}>User Profile</Link> 
          </li>
        </ul>

        <div className="me-0">
          <ul className="d-flex navbar-nav">
            <li className="nav-item m-1">
              <Link className="nav-link fs-5" to="/login">
                Login
              </Link>
            </li>
            <li className="nav-item m-1">
              <Link className="nav-link fs-5" to="/register">
                Register
              </Link>
            </li>
          </ul>
        </div>
      </div>
    </nav>
  );
};

export default Navbar;
