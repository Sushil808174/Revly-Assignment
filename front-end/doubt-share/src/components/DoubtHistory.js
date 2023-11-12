import React, { useEffect, useState } from 'react';

const DoubtHistory = () => {
  const [doubts, setDoubts] = useState([]);

  useEffect(() => {
    const token = localStorage.getItem('token');
    const userId = localStorage.getItem('userId');
    fetch(`http://localhost:8888/doubt-history/${userId}`, {
      headers: {
        'Authorization': `Bearer ${token}`,
        'Content-Type': 'application/json',
      },})
      .then(response => response.json())
      .then(data => setDoubts(data))
      .catch(error => console.error('Error fetching doubt history:', error));
  }, []);

  return (
    <div className="container mt-5">
      <h2>Doubt History</h2>
      {doubts.length === 0 ? (
        <p>No doubts found.</p>
      ) : (
        <ul className="list-group">
          {doubts.map((doubt) => (
            <li key={doubt.doubtId} className="border rounded list-group-item m-2" >
              <h5>{doubt.subjectType}</h5>
              <p>Doubt: {doubt.doubtText}</p>
              <p>Tutor Email: {doubt.tutorEmail ? doubt.tutorEmail : 'No Tutor Found'}</p>
              <p>Timestamp: {new Date(doubt.timeStamp).toLocaleString()}</p>
              {/* Add more details as needed */}
            </li>
          ))}
        </ul>
      )}
    </div>
  );
};

export default DoubtHistory;
