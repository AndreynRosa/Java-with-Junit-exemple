import React from "react";
import PostView from "./component/PostView";

import { Row, Container, Col } from "react-bootstrap";

import { connect } from "react-redux";
import * as PostsActions from "./store/actions/posts";
import { bindActionCreators } from "redux";
import BasicModal from "./component/BasicModal";


const App = ({savePost}) => (
  <div className="App">
    <Container>
      <Row>
        <Col md={12} className="postBtnView">
       
          <BasicModal onSave={savePost} ></BasicModal>
        </Col>
        <Col md={12} className="modalView">
          <PostView ></PostView>
        </Col>
      </Row>
    </Container>
  </div>
);
const mapStateToProps = state => ({
  posts: state.posts.posts,
  status: state.posts.status
});
const mapDispatchToProps = dispatch =>
  bindActionCreators(PostsActions, dispatch);


export default connect(mapStateToProps, mapDispatchToProps)(App);
