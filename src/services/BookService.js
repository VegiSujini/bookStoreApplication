// src/services/BookService.js
import axios from 'axios';

// Create an Axios instance with base settings
const apiClient = axios.create({
  baseURL: 'http://localhost:8080/api', // Adjust to your book service URL
  headers: {
    'Content-Type': 'application/json',
  },
});

// Fetch the token from localStorage
const token = localStorage.getItem('token');
if (token) {
  // Set the token as a default Authorization header for all future Axios requests
  apiClient.defaults.headers.common['Authorization'] = `Bearer ${token}`;
}

const BookService = {
  getBooks: () => {
    return apiClient.get('/books'); // This call will include the Authorization header
  },
  getBookById: (id) => {
    return apiClient.get(`/books/${id}`); // This call will also include the token
  },
};

export default BookService;
