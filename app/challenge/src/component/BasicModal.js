import React, { Component } from "react";
import PropTypes from "prop-types";

import { Modal, Button, InputGroup, Form } from "react-bootstrap";

class BasicModal extends Component {
  static propTypes = {
    onSave: PropTypes.func
  };
  constructor(props) {
    super(props);
    this.state = {
      show: false,
      title: "",
      description: ""
    };
  }

  handleShow() {
    this.setState({ show: true });
  }
  handleClose() {
    this.setState({ show: false });
  }
  onChangeTitleHandler(e) {
    this.setState({ title: e.target.value }, () => {});
  }
  onChangeDescHandler(e) {
    this.setState({ description: e.target.value }, () => {});
  }
  onclickHandler() {
    if (this.state.title !== "" && this.state.description) {
      this.props.onSave(this.state.title, this.state.description);
      this.setState({title: '', description: ''})
      this.handleClose();
    }else{

    }
  }

  render() {
    return (
      <>
       
          <Button
            className="largeBtn"
            variant="primary"
            onClick={() => this.handleShow()}
          >
            Criando Post
          </Button>
    
        <Modal show={this.state.show} onHide={() => this.handleClose()}>
          <Modal.Header closeButton>
            <Modal.Title>Novos Posts</Modal.Title>
          </Modal.Header>

          <Modal.Body className="modalBody">
            <h3>Preencha o formulário</h3>

            <Form>
              <Form.Group controlId="postForm">
                <Form.Label>Titulo</Form.Label>
                <Form.Control
                  type="text"
                  value={this.state.title}
                  name="title"
                  placeholder="Escreva o titlo"
                  onChange={e => this.onChangeTitleHandler(e)}
                />
                <InputGroup className="text-muted">
                  Seu post inciára com 0 (zero) votos.
                </InputGroup>
              </Form.Group>

              <Form.Group controlId="formBasicPassword">
                <Form.Label>Descrição</Form.Label>
                <Form.Control
                  type="text"
                  value={this.state.description}
                  placeholder="Descrição"
                  name="description"
                  onChange={e => this.onChangeDescHandler(e)}
                />
              </Form.Group>

              <Button variant="primary" onClick={() => this.onclickHandler()}>
                Salvar
              </Button>
              <Button variant="secondary" style={{left: "68%", position: "relative"}}onClick={() => this.handleClose()}>
                Fechar
              </Button>
            </Form>
          </Modal.Body>
          <Modal.Footer></Modal.Footer>
        </Modal>
      </>
    );
  }
}
export default BasicModal;
