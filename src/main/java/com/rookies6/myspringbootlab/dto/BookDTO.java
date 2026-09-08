package com.rookies6.myspringbootlab.dto;

import com.rookies6.myspringbootlab.entity.Book;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.time.LocalDate;

public class BookDTO {

    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    @Builder
    public static class BookCreateRequest{

        @NotBlank(message = "제목은 필수입니다")
        private String title;

        @NotBlank(message = "저자는 필수입니다")
        private String author;

        @NotBlank(message = "도서번호는 필수입니다")
        private String isbn;

        @NotNull(message = "가격은 필수입니다")
        private Integer price;

        @NotNull(message = "출판일자는 필수입니다")
        private LocalDate publishDate;

    public Book toEntity() {
        return Book.builder()
                .title(getTitle())
                .author(getAuthor())
                .isbn(getIsbn())
                .price(getPrice())
                .publishDate(getPublishDate())
                .build();
        }
    }

    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    @Builder
    public static class BookUpdateRequest{
        private Integer price;
        private String title;
        private String author;
        private LocalDate publishDate;


    }

    @Getter @Setter
    @NoArgsConstructor @AllArgsConstructor
    @Builder
    public static class BookResponse{
        private Long id;
        private String title;
        private String author;
        private String isbn;
        private Integer price;
        private LocalDate publishDate;

        public static BookResponse from(Book book){
            return BookResponse.builder()
                    .id(book.getId())
                    .title(book.getTitle())
                    .author(book.getAuthor())
                    .isbn(book.getIsbn())
                    .price(book.getPrice())
                    .publishDate(book.getPublishDate())
                    .build();
        }
    }

}


