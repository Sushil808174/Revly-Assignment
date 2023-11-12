import React, { useEffect, useState } from 'react';
// import './DoubtList.css'
const DoubtList = () => {
  const [doubts, setDoubts] = useState([]);

  useEffect(() => {
    const token = localStorage.getItem("token");
    fetch('http://localhost:8888/all-doubt', {
      headers: {
        'Authorization': `Bearer ${token}`,
        'Content-Type': 'application/json',
      },})
      .then((response) => response.json())
      .then((data) => setDoubts(data))
      .catch((error) => console.error('Error fetching doubts:', error));
  }, []);

  return (
    <div className='container mt-5'>
      <h2 className='text-center'>Doubt List</h2>
      <ul className='list-unstyled'>
        {doubts.map((doubt) => (
          <li key={doubt.doubtId} className='border p-3 mb-3 rounded shadow'>
            <h3>User Name: {doubt.student.userName}</h3>
            <p className='text-uppercase'>Language: <span>{doubt.student.language}</span></p>
            <p className='text-uppercase'>Class Grade: <span> {doubt.student.classGrade}</span></p>
            <p className='text-uppercase'>Subject: <span>{doubt.subjectType}</span></p>
            <div className='card'>
              <div className='card-body'>Doubt Text: <span>{doubt.doubtText}</span></div>
            </div>
            <p className='text-uppercase'>Tutor Email: <span>{doubt.tutorEmail ? doubt.tutorEmail : 'No Tutor Found'}</span></p>
            <p className='text-uppercase'>Doubt Raise Time: <span>{new Date(doubt.timeStamp).toLocaleString()}</span></p>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default DoubtList;
