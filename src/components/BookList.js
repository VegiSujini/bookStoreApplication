import React, { useState } from 'react';
import AuthService from '../services/AuthService';
import { useNavigate } from 'react-router-dom'; // Use useNavigate instead of useHistory

const Login = () => {
  const [username, setUsername] = useState(''); // Capitalize setUserName for consistency
  const [password, setPassword] = useState('');
  const navigate = useNavigate(); // Replace useHistory with useNavigate

  const handleSubmit = (e) => {
    e.preventDefault();
    AuthService.login(username, password)
      .then(() => {
        navigate('/'); // Replace history.push with navigate
      })
      .catch(error => {
        console.error('Login failed:', error);
        alert('Invalid credentials');
      });
  };

  return (
    <div>
      <h2>Login</h2>
      <form onSubmit={handleSubmit}>
        <input
          type="text"
          placeholder="Username" // Changed placeholder from 'userName' to 'Username' for readability
          value={username}
          onChange={e => setUsername(e.target.value)} // Use setUserName (capitalize 'U')
          required
        />
        <input
          type="password"
          placeholder="Password"
          value={password}
          onChange={e => setPassword(e.target.value)}
          required
        />
        <button type="submit">Login</button>
      </form>
    </div>
  );
};

export default Login;
