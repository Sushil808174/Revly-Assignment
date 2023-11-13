import React, { useState, useEffect } from 'react';

const ActiveTutor = () => {
  const [tutors, setTutors] = useState([]);

  useEffect(() => {
    // Fetch data from the server
    fetch('http://localhost:8888/all-tutor')
      .then((response) => response.json())
      .then((data) => setTutors(data))
      .catch((error) => console.error('Error fetching tutors:', error));
  }, []);

  return (
    <div className="container mt-4 table-responsive">
      <h2>Tutor List</h2>
      <table className="table table-bordered align-middle">
        <thead>
          <tr>
            <th scope="col">User Name</th>
            <th scope="col">Email</th>
            <th scope="col">User Type</th>
            <th scope="col">Language</th>
            <th scope="col">Class Grade</th>
            <th scope="col">Experties</th>
            {/* Add more headings based on your tutor object */}
          </tr>
        </thead>
        <tbody className='table-group-divider'>
          {tutors.map((tutor) => (
            <tr key={tutor.userId}>
              <td>{tutor.userName}</td>
              <td>{tutor.emailId}</td>
              <td>{tutor.userType}</td>
              <td>{tutor.language}</td>
              <td>{tutor.classGrade}</td>
              <td>{tutor.tutorExperties}</td>
              {/* Add more cells based on your tutor object */}
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default ActiveTutor;
