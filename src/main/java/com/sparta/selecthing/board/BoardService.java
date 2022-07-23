package com.sparta.selecthing.board;

import com.sparta.selecthing.comment.Comment;
import com.sparta.selecthing.comment.CommentRepository;
import com.sparta.selecthing.comment.CommentSaveRequestDto;
import com.sparta.selecthing.user.User;
import com.sparta.selecthing.user.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BoardService {

    private final BoardRepository boardRepository;
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;

    public BoardService(BoardRepository boardRepository, CommentRepository commentRepository, UserRepository userRepository) {
        this.boardRepository = boardRepository;
        this.commentRepository = commentRepository;
        this.userRepository = userRepository;
    }

    //글 상세보기
//    @Transactional
//    public BoardDto showDetailedBoard(Long boardId) {
//        Board entity = boardRepository.findById(boardId)
//                .orElseThrow(() -> new IllegalArgumentException("글 상세보기 실패 : 아이디를 찾을 수 없습니다."));
//        return new BoardDto(entity);
//    }
    @Transactional
    public Board showDetailedBoard(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> {
                    return new IllegalArgumentException("글 상세보기 실패 : 아이디를 찾을 수 없습니다.");
                });
    }

    @Transactional
    public void deleteBoard(Long id) {
        boardRepository.deleteById(id);
    }

    @Transactional
    public void writeComment(CommentSaveRequestDto commentSaveRequestDto) {

        User user = userRepository.findById(commentSaveRequestDto.getUserId()).orElseThrow(() -> {
            return new IllegalArgumentException("댓글 쓰기 실패 : 유저 id를 찾을 수 없습니다.");
        });

        Board board = boardRepository.findById(commentSaveRequestDto.getBoardId()).orElseThrow(() -> {
            return new IllegalArgumentException("댓글 쓰기 실패 : 게시글 id를 찾을 수 없습니다.");
        });

        Comment comment = new Comment();
        comment.update(user, board, commentSaveRequestDto.getContent());

        commentRepository.save(comment);

//        Comment comment = Comment.builder()
//                        .user(user)
//                        .board(board)
//                        .content(commentSaveRequestDto.getContent())
//                        .build();
//
//        commentRepository.save(comment);


//        requestComment.setUser(user);
//        requestComment.setBoard(board);
//        commentRepository.save(requestComment);
    }

    public void deleteComment(Long commentId) {
        commentRepository.deleteById(commentId);
    }
}