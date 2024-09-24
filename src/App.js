import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import BookList from './components/BookList';
import BookDetails from './components/BookDetails';
import Login from './components/Login';
import Cart from './components/Cart';

function App() {
  return (
    <Router>
      <div>
        <Routes>
          <Route path="/" element={<BookList />} />
          <Route path="/login" element={<Login />} />
          <Route path="/book/:id" element={<BookDetails />} />
          <Route path="/cart" element={<Cart />} />
        </Routes>
      </div>
    </Router>
  );
}

export default App;
