import React, { useState } from 'react';
import { Form, Button } from 'react-bootstrap';

const ExperienceForm = () => {
  const [experiences, setExperiences] = useState([
    { company: '', startYear: '', endYear: '' },
  ]);

  const atualizarExperiencia = (index, field, value) => {
    const updatedExperiences = [...experiences];
    updatedExperiences[index][field] = value;
    setExperiences(updatedExperiences);
  };

  const adicionarExperiencia = () => {
    setExperiences([
      ...experiences,
      { company: '', startYear: '', endYear: '' },
    ]);
  };

  return (
    <div>
      <h4 className="mt-4">Experiências Profissionais</h4>
      {experiences.map((experience, index) => (
        <div key={index} className="mt-3">
          <Form.Group controlId={`formCompany${index}`}>
            <Form.Label>Empresa</Form.Label>
            <Form.Control
              type="text"
              value={experience.company}
              onChange={(e) =>
                atualizarExperiencia(index, 'company', e.target.value)
              }
              placeholder="Digite o nome da empresa"
            />
          </Form.Group>
          <Form.Group controlId={`formStartYear${index}`} className="mt-3">
            <Form.Label>Ano de Início</Form.Label>
            <Form.Control
              type="text"
              value={experience.startYear}
              onChange={(e) =>
                atualizarExperiencia(index, 'startYear', e.target.value)
              }
              placeholder="Digite o ano de início"
            />
          </Form.Group>
          <Form.Group controlId={`formEndYear${index}`} className="mt-3">
            <Form.Label>Ano de Saída (opcional)</Form.Label>
            <Form.Control
              type="text"
              value={experience.endYear}
              onChange={(e) =>
                atualizarExperiencia(index, 'endYear', e.target.value)
              }
              placeholder="Digite o ano de saída"
            />
          </Form.Group>
        </div>
      ))}

      <Button variant="secondary" className="mt-3" onClick={adicionarExperiencia}>
        Adicionar Experiência
      </Button>

      <Button variant="primary" className="mt-3 ms-2">
        Salvar
      </Button>
    </div>
  );
};

export default ExperienceForm;
