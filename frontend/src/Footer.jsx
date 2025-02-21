import React from "react";
import { Container } from "react-bootstrap";

const Footer = () => {
  return (
    <footer className="bg-dark text-light text-center py-1 mt-4">
      <Container>
        <p>&copy; {new Date().getFullYear()} Mário Patricio. Todos os direitos reservados.</p>
      </Container>
    </footer>
  );
};

export default Footer;
