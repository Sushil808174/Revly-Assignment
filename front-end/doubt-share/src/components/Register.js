import React, { useState } from "react";


const Register = () => {
  const [userName, setUserName] = useState("");
  const [email, setEmail] = useState("");
  const [password, setPassword] = useState("");
  const [userType, setUserType] = useState("STUDENT");
  const [tutorExperties, setTutorExperties] = useState("");
  const [language, setLanguage] = useState("");
  const [classGrade, setClassGrade] = useState("");

  const handleRegister = (e) => {
    e.preventDefault();
    let data = {}
    if(userType === "STUDENT"){
      data = {
        userName: userName,
        emailId: email,
        password: password,
        userType: userType, 
        language: language,
        classGrade: classGrade
      };
    }else{
       data = {
       userName: userName,
       emailId: email,
       password: password,
       userType: userType, 
       tutorExperties: tutorExperties,
       language: language,
       classGrade: classGrade
     };
    }
    console.log(data)
    fetch("http://localhost:8888/register-user", {
      method: "POST",
      headers: { "Content-Type": "application/json" },
      body: JSON.stringify(data)
  })
      .then(res => res.json())
      .then(res => {
          console.log(res)
          if (res) {
              alert("Registeration successfully!")
            console.log('yes')
          } else {
              alert(res.data)
              console.log("no")
          }

      })
      .catch(error => {

          console.error(error);
      });

  };

  return (
    <div className="container mt-5">
      <div className="row justify-content-center">
        <div className="col-md-6">
          <div className="card shadow">
            <div className="card-body">
              <h2 className="text-center mb-4">Register</h2>
              <form onSubmit={handleRegister}>
                <div className="mb-3">
                  <label htmlFor="userName" className="form-label">
                    User Name
                  </label>
                  <input
                    type="text"
                    className="form-control"
                    id="userName"
                    value={userName}
                    onChange={(e) => setUserName(e.target.value)}
                    required
                  />
                </div>
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
                <div className="mb-3">
                  <label htmlFor="userType" className="form-label">
                    User Type
                  </label>
                  <select
                    className="form-select"
                    id="userType"
                    value={userType}
                    onChange={(e) => setUserType(e.target.value)}
                  >
                    <option value="STUDENT">Student</option>
                    <option value="TUTOR">Tutor</option>
                  </select>
                </div>
                {userType === "TUTOR" && (
                  <>
                    <div className="mb-3">
                      <label htmlFor="tutorExperties" className="form-label">
                        Tutor Experties
                      </label>

                      <select
                        className="form-select"
                        id="subjectType"
                        value={tutorExperties}
                        onChange={(e) => setTutorExperties(e.target.value)}
                        required
                      >
                        <option value="" disabled>
                          Select Subject Type
                        </option>
                        <option value="MATHEMATICS">Mathematics</option>
                        <option value="HISTORY">History</option>
                        <option value="CHEMISTRY">Chemistry</option>
                        <option value="BIOLOGY">Biology</option>
                        <option value="PHYSICS">Physics</option>
                        <option value="SANSKRIT">Sanskrit</option>
                        <option value="ENGLISH">English</option>
                      </select>
                    </div>
                  </>
                )}
                <div className="mb-3">
                  <label htmlFor="language" className="form-label">
                    Language
                  </label>
                  <input
                    type="text"
                    className="form-control"
                    id="language"
                    value={language}
                    onChange={(e) => setLanguage(e.target.value)}
                    required
                  />
                </div>
                <div className="mb-3">
                  <label htmlFor="classGrade" className="form-label">
                    Class Grade
                  </label>
                  <input
                    type="text"
                    className="form-control"
                    id="classGrade"
                    value={classGrade}
                    onChange={(e) => setClassGrade(e.target.value)}
                    required
                  />
                </div>
                <button type="submit" className="btn btn-primary w-100">
                  Register
                </button>
              </form>
            </div>
          </div>
        </div>
      </div>
    </div>
  );
};

export default Register;
