package org.example;

import lombok.*;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private String title;
    private String director;
    private int year;
}
