// src/components/BookDetails.js
import React, { useState, useEffect } from 'react';
import { useParams } from 'react-router-dom';
import BookService from '../services/BookService';

const BookDetails = () => {
  const { id } = useParams();
  const [book, setBook] = useState(null);
  const [error, setError] = useState(null);

  useEffect(() => {
    BookService.getBookById(id)
      .then(response => {
        setBook(response.data);
      })
      .catch(error => {
        console.error('Error fetching book details:', error);
        setError('Failed to fetch book details.');
      });
  }, [id]);

  if (error) {
    return <div>{error}</div>;
  }

  if (!book) {
    return <div>Loading...</div>;
  }

  return (
    <div>
      <h2>{book.title}</h2>
      <p>Author: {book.author}</p>
      <p>Price: ${book.price}</p>
      <button onClick={() => alert('Added to cart')}>Add to Cart</button>
    </div>
  );
};

export default BookDetails;
