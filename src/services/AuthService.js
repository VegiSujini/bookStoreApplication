// src/services/AuthService.js
import axios from 'axios'; // Import axios at the top of the file

// Define the API URL - adjust this to match your backend URL
const API_URL = 'http://localhost:8081/api/authenticate'; // Replace with your backend authentication endpoint

const AuthService = {
  login: async (username, password) => {
    try {
      const response = await axios.post(API_URL, { username, password }); // Make sure this matches your backend's request structure
      const token = response.data; // Ensure this matches your backend's response structure (e.g., response.data.token if it's wrapped)

      // Store the token in localStorage for subsequent requests
      localStorage.setItem('token', token);

      // Set the token as a default Authorization header for future requests
      axios.defaults.headers.common['Authorization'] = `Bearer ${token}`;

      return token;
    } catch (error) {
      console.error('Error in login:', error.response ? error.response.data : error.message);
      throw error;
    }
  },
};

export default AuthService;
