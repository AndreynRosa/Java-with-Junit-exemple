import React from "react";
import { Col, Button,  } from "react-bootstrap";

const Post = props => (
  <Col className="postBox" md={12}>
    <h1 className="postTitle">
      {props.title}
      <div className="votesCoounter pushLeft">{props.votes} </div>
    </h1>{" "}
    <div className= "postDescription">
      {props.description}
    </div>
    <div className="btnGroup">
      <Button
        className="btnPost btnSize"
        variant="primary"
        onClick={() => {
          props.addVote(props.postId);
        }}
      >
        Votar
      </Button>

      <Button
        className="btnPost btnSize"
        variant="danger"
        onClick={() => {
          props.deletePost(props.postId);
        }}
      >
        Deletar
      </Button>
      <Button
        className="btnSize"
        variant="warning"
        onClick={() => {
          props.removeVote(props.postId);
        }}
      >
        Desvotar
      </Button>
    </div>
  </Col>
);

export default Post;
