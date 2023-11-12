import React, { useState } from 'react';

const CreateDoubt = () => {

  const [subjectType, setSubjectType] = useState('');
  const [doubtText, setDoubtText] = useState('');

  const handleDoubtSubmit = (e) => {
    e.preventDefault();
    const userId = localStorage.getItem('userId');
    const token = localStorage.getItem('token');
    console.log(subjectType);
    console.log(doubtText)
    fetch(`http://localhost:8888/ask-doubt/${userId}`, {
      method: 'POST',
      headers: {
        'Authorization': `Bearer ${token}`,
        'Content-Type': 'application/json',
      },
      body: JSON.stringify({
        subjectType,
        doubtText,
      }),
    })
      .then(response => response.json())
      .then(data => {
        console.log('Doubt submitted successfully', data);
        // Handle success, e.g., show a success message to the user
      })
      .catch(error => {
        console.error('Error submitting doubt', error);
        // Handle error, e.g., show an error message to the user
      });
  };

  return (
    <div className="container mt-5">
      <h2>Create Doubt</h2>
      <form onSubmit={handleDoubtSubmit}>
        {/* Subject Type Dropdown */}
        <div className="mb-3">
          <label htmlFor="subjectType" className="form-label">
            Subject Type
          </label>
          <select
            className="form-select"
            id="subjectType"
            value={subjectType}
            onChange={(e) => setSubjectType(e.target.value)}
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

        {/* Doubt Text */}
        <div className="mb-3">
          <label htmlFor="doubtText" className="form-label">
            Doubt Text
          </label>
          <textarea
            className="form-control"
            id="doubtText"
            value={doubtText}
            onChange={(e) => setDoubtText(e.target.value)}
            required
          ></textarea>
        </div>

        <button type="submit" className="btn btn-primary">
          Submit Doubt
        </button>
      </form>
    </div>
  );
};

export default CreateDoubt;
