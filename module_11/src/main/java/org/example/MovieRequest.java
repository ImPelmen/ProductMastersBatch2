package org.example;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieRequest {

    @NonNull
    private String name;

    @NonNull
    private String director;

    private int year;
}
