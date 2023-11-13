import React, { useRef, useState } from "react";
import { Navigate } from "react-router-dom";



const Login = () => {
    const log = useRef(false);
    const [email, setEmail] = useState('');
    const [password, setPassword] = useState('');
    
    const handleLogin = async (e) => {
        e.preventDefault();
        console.log(email);
        console.log(password);
       

        try {
          const response = await fetch('http://localhost:8888/signIn', {
            method: 'GET',
            headers: {
                'Authorization': 'Basic ' + btoa(email + ':' + password)
            },
          });
    
          if (!response.ok) {
            console.error('Login failed');
            return;
          }
          const getToken = response.headers.get("Authorization");
          const result = await response.json();
          console.log(result);
          log = false;
          localStorage.setItem('userId',result.userId);
          localStorage.setItem('token', getToken);
          console.log(getToken);
          // alert("login successfully!")
        } catch (error) {
          console.error('Error during login:', error);
        }
        
    };

  return (
    <div className="container mt-5">
      {!log && <div class="alert alert-warning" role="alert">
            You are not Logged In!
        </div>}
      {log && <div class="alert alert-success" role="alert">
            Loggin successfully!...
        </div>}
      <div className="row justify-content-center">
        <div className="col-md-6">
          <div className="card shadow">
            <div className="card-body">
              <h2 className="text-center mb-4">Login</h2>
              <form onSubmit={handleLogin}>
                <div className="mb-3">
                  <label htmlFor="email" className="form-label">
                    Email address
                  </label>
                  <input
                    type="email"
                    className="form-control"
                    id="email"
                    value={email}
                    onChange={(e) => setEmail(e.target.value)}
                    required
                  />
                </div>
                <div className="mb-3">
                  <label htmlFor="password" className="form-label">
                    Password
                  </label>
                  <input
                    type="password"
                    className="form-control"
                    id="password"
                    value={password}
                    onChange={(e) => setPassword(e.target.value)}
                    required
                  />
                </div>
                <button type="submit" className="btn btn-primary w-100">
                  Login
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Login;
