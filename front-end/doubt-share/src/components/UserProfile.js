import React, { useEffect, useState } from "react";

const UserProfile = () => {
  const userId = localStorage.getItem("userId");
  const [user, setUser] = useState(null);
  const token = localStorage.getItem("token"); // Assuming you store the token in localStorage

  useEffect(() => {
    // Fetch user details based on userId with JWT token
    fetch(`http://localhost:8888/user/${userId}`, {
      headers: {
        Authorization: `Bearer ${token}`,
        "Content-Type": "application/json",
      },
    })
      .then((response) => response.json())
      .then((data) => setUser(data))
      .catch((error) => console.error("Error fetching user profile:", error));
  }, [userId, token]);

  if (!user) {
    return <div class="alert alert-warning" role="alert">
    You are not Logged in!....
</div>; // You can replace this with a loading spinner or other UI indication
  }

  const handleLogout = ()=>{
    localStorage.removeItem("userId");
    localStorage.removeItem("token");
    window.location.reload();
  }

  return (
    
    <div className="container mt-5">
      <div className="row justify-content-center">
         
        <div
          className="card shadow"
          style={{ width: "500px", height: "350px" }}
        >
          <div className="card-body">
            <h5 className="card-title mb-4">User Details</h5>
            <ul className="list-group list-group-flush">
              <li className="list-group-item">
                <strong>User Name :</strong> {user.userName}
              </li>
              <li className="list-group-item">
                <strong>Email ID :</strong> {user.emailId}
              </li>
              <li className="list-group-item">
                <strong>User Type :</strong> {user.userType}
              </li>
              <li className="list-group-item">
                <strong>Language :</strong> {user.language}
              </li>
              <li className="list-group-item">
                <strong>Class :</strong> {user.classGrade}
              </li>
            </ul>
            <div className="mt-4">
              <button className="btn btn-danger" onClick={handleLogout}>Logout</button>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default UserProfile;
