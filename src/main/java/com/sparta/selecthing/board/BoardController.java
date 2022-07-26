package com.sparta.selecthing.board;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
@RestController
//@RestController
public class BoardController {

    private final BoardService boardService;

    public BoardController(BoardService boardService) {
        this.boardService = boardService;
    }


    //상세 게시글 열람
    @GetMapping("/boards/{boardId}/details")
    public BoardDto showDetailedBoard(@PathVariable Long boardId) {
//        model.addAttribute("board", boardService.showDetailedBoard(id));
        return boardService.showDetailedBoard(boardId);
    }
    //상세 게시글 삭제
    @DeleteMapping("/boards/{boardId}/details")
    public ResponseEntity<BoardDto> deleteBoard(@PathVariable Long boardId) {
        boardService.deleteBoard(boardId);
        return new ResponseEntity<>(HttpStatus.OK);
    }





//    @PostMapping("/board")
//    public ResponseEntity<Board> save(@RequestBody Board board){
//        boardService.writeBoard(board);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }

//    @PostMapping("/board/{id}/comment") //@AuthenticationPrincipal principalDetail principalDetail
//    public ResponseEntity<CommentResponseDto> commentSave(
//            @PathVariable id, @RequestBody Comment comment){
//        boardService.writeComment(user, boardId, comment);
//        return new ResponseEntity<>(HttpStatus.OK);
//    }


    //dto/?




}
