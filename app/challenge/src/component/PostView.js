import React from "react";
import { connect } from "react-redux";
import { bindActionCreators } from "redux";
import * as PostsActions from "../store/actions/posts";
import { Col } from "react-bootstrap";
import Post from "./Post";



const PostView = ({ posts, getPosts, status, setVote ,removePost, removeVote}) => (
  <Col md={12}  onLoad={status === "initial" ? getPosts() : null}>

    {posts.map(post => {
      return (
        <Post
          key={post.id}
          title={post.title}
          description={post.description}
          votes={post.upVotes.length}
          addVote={setVote}
          deletePost={removePost}
          postId={post.id}
          removeVote={removeVote}
        ></Post>
      );
    })}
  </Col>
);

const mapStateToProps = state => ({
  posts: state.posts.posts,
  status: state.posts.status
});
const mapDispatchToProps = dispatch =>
  bindActionCreators(PostsActions, dispatch);
export default connect(mapStateToProps, mapDispatchToProps)(PostView);
