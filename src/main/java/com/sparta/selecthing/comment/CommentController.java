package com.sparta.selecthing.comment;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    //상세 게시글 보기(댓글 포함?
    @GetMapping("/api/{boardId}/comments") //게시글마다 댓글 다르니까~!
    public List<CommentResponseDto> showComments(@PathVariable Long boardId) {
        return commentService.showComments(boardId);

    }

//    // 댓글 목록 보기
//    @GetMapping("/api/comment/{articlesId}")
//    public ResponseEntity<Result<List<CommentResponseDto>>> showComments(@PathVariable Long articlesId) {
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(new Result<List<CommentResponseDto>>(commentService.showComments(articlesId)));
//    }

}