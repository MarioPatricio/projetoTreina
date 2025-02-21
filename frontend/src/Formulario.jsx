import React, { useState } from "react";
import { Form, Button } from "react-bootstrap";
import Experiencia from "./Experiencia";

const FormComponent = () => {
  const [formacoes, setFormacoes] = useState([{ formacao: "", instituicao: "", ano: "" }]);
  
  const [isWhatsApp, setIsWhatsApp] = useState(false);

  const adicionarFormacao = () => {
    setFormacoes([...formacoes, { formacao: "", instituicao: "", ano: "" }]);
  };

  const atualizarFormacao = (index, campo, valor) => {
    const novasFormacoes = [...formacoes];
    novasFormacoes[index][campo] = valor;
    setFormacoes(novasFormacoes);
  };

  return (
    <div className="container mt-4">
      <h2>Inserir Dados</h2>
      <Form>
        <Form.Group controlId="formNome">
          <Form.Label>Nome</Form.Label>
          <Form.Control type="text" placeholder="Digite o nome" />
        </Form.Group>

        <Form.Group controlId="formEmail" className="mt-3">
          <Form.Label>Email</Form.Label>
          <Form.Control type="email" placeholder="Digite o email" />
        </Form.Group>

        <Form.Group controlId="formTelefone" className="mt-3">
          <Form.Label>Telefone</Form.Label>
          <Form.Control type="text" placeholder="Digite o telefone" />
        </Form.Group>

        <Form.Group controlId="formWhatsApp" className="mt-3">
          <Form.Check
            type="checkbox"
            label="Este telefone é WhatsApp"
            checked={isWhatsApp}
            onChange={(e) => setIsWhatsApp(e.target.checked)}
          />
        </Form.Group>

        <h4 className="mt-4">Endereço</h4>
        <Form.Group controlId="formRua" className="mt-3">
          <Form.Label>CEP</Form.Label>
          <Form.Control type="text" placeholder="Digite o CEP"/>
        </Form.Group>
        <Form.Group controlId="formNumero" className="mt-3">
          <Form.Label>Número</Form.Label>
          <Form.Control type="text" placeholder="Digite o número" />
        </Form.Group>
        <Form.Group controlId="formBairro" className="mt-3">
          <Form.Label>Bairro</Form.Label>
          <Form.Control type="text" placeholder="Digite o bairro" />
        </Form.Group>
        <Form.Group controlId="formCep" className="mt-3">
          <Form.Label>Rua</Form.Label>
          <Form.Control type="text" placeholder="Digite a rua" />
        </Form.Group>
        <Form.Group controlId="formCidade" className="mt-3">
          <Form.Label>Cidade</Form.Label>
          <Form.Control type="text" placeholder="Digite a cidade" />
        </Form.Group>
        <Form.Group controlId="formUF" className="mt-3">
          <Form.Label>UF</Form.Label>
          <Form.Control type="text" placeholder="Digite a UF (ex: SP)" />
        </Form.Group>

        <h4 className="mt-4">Formações</h4>
        {formacoes.map((formacao, index) => (
          <div key={index} className="mt-3">
            <Form.Group controlId={`formFormacao${index}`}>
              <Form.Label>Escolha a Formação</Form.Label>
              <Form.Control
                as="select"
                value={formacao.formacao}
                onChange={(e) => atualizarFormacao(index, "formacao", e.target.value)}
              >
                <option>Técnico</option>
                <option>Graduação</option>
                <option>Pós-Graduação</option>
              </Form.Control>
            </Form.Group>
            <Form.Group controlId={`formInstituicao${index}`} className="mt-3">
              <Form.Label>Instituição</Form.Label>
              <Form.Control
                type="text"
                value={formacao.instituicao}
                onChange={(e) => atualizarFormacao(index, "instituicao", e.target.value)}
                placeholder="Digite a instituição"
              />
            </Form.Group>
            <Form.Group controlId={`formAno${index}`} className="mt-3">
              <Form.Label>Ano de Conclusão</Form.Label>
              <Form.Control
                type="text"
                value={formacao.ano}
                onChange={(e) => atualizarFormacao(index, "ano", e.target.value)}
                placeholder="Digite o ano de conclusão"
              />
            </Form.Group>
          </div>
        ))}

        <Button variant="secondary" className="mt-3" onClick={adicionarFormacao}>
          Adicionar Formação
        </Button>

        <Button variant="primary" className="mt-3 ms-2">
          Salvar
        </Button>

        <Experiencia />
        
      </Form>
    </div>
  );
};

export default FormComponent;
