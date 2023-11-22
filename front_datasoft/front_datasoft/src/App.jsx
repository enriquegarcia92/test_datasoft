import React, { useEffect, useState } from 'react';
import { Modal, Button } from 'react-bootstrap';
import axios from 'axios';
import './App.css';

function App() {
  const [data, setData] = useState([]);
  const [selectedCategory, setSelectedCategory] = useState('All');
  const [error, setError] = useState(null);
  const [loading, setLoading] = useState(true);
  const [showModal, setShowModal] = useState(false);
  const [selectedProduct, setSelectedProduct] = useState(null);


  useEffect(() => {
    const fetchData = async () => {
      try {
        const response = await axios.get('http://localhost:8080/productos/getAll');
        setData(response.data);
        console.log(response.data)
      } catch (error) {
        setError(error);
      } finally {
        setLoading(false);
      }
    };

    fetchData();
  }, []);


  const categories = ['All', 'Camisetas', 'Pantalones', 'Zapatos', 'Accesorios'];

  const handleCategoryChange = (event) => {
    setSelectedCategory(event.target.value);
  };

  const handleProductDetail = (product) => {
    setSelectedProduct(product);
    setShowModal(true);
  };

  const handleCloseModal = () => {
    setShowModal(false);
  };


  return (
    <div className="container mt-3">
      {/* Category Dropdown */}
      <div className="mb-3">
        <label htmlFor="categorySelect" className="form-label">
          Choose a Category:
        </label>
        <select
          className="form-select"
          id="categorySelect"
          value={selectedCategory}
          onChange={handleCategoryChange}
        >
        <option value="0" selected></option>
          {categories.map((category) => (
            <option key={category} value={category}>
              {category === 'All' ? 'All Products' : category}
            </option>
          ))}
        </select>
      </div>

      {/* Product Cards */}
      <div className="row row-cols-1 row-cols-md-3 g-4">
        {data
          .filter((data) =>
            selectedCategory === 'All'
              ? true
              : data.categoria.nombre === selectedCategory
          )
          .map((data) => (
            <div key={data.prd_nombre} className="col">
              <div className="card h-100">
              <img
                  src={`data:image/png;base64,${data.prd_imagen}`}
                  className="card-img-top img-thumbnail"
                  alt={data.prd_name}
                />
                <div className="card-body">
                  <h5 className="card-title">{data.prd_nombre}</h5>
                  <p className="card-text">Price: ${data.prd_precio}</p>
                  <button
                    className="btn btn-primary"
                    onClick={() => handleProductDetail(data)}
                  >
                    Product Detail
                  </button>                
                  </div>
              </div>
            </div>
          ))}
      </div>

      {/* Product Detail Modal */}
      <Modal show={showModal} onHide={handleCloseModal}>
        <Modal.Header closeButton>
          <Modal.Title>{selectedProduct && selectedProduct.prd_nombre}</Modal.Title>
        </Modal.Header>
        <Modal.Body>
        <img
                  src={`data:image/png;base64,${selectedProduct.prd_imagen}`}
                  className="card-img-top img-thumbnail"
                  alt={data.prd_name}
                />
          <p>Id: {selectedProduct && selectedProduct.prd_id}</p>
          <p>Price: ${selectedProduct && selectedProduct.prd_price}</p>
          <p>Description: {selectedProduct && selectedProduct.prd_descripcion}</p>
          <p>State: {selectedProduct && selectedProduct.prd_estado}</p>
          {/* Add other product details here */}
        </Modal.Body>
        <Modal.Footer>
          <Button variant="secondary" onClick={handleCloseModal}>
            Close
          </Button>
        </Modal.Footer>
      </Modal>
    </div>
  );
}

export default App;

