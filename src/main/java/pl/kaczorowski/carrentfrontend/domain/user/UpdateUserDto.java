package pl.kaczorowski.carrentfrontend.domain.user;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class UpdateUserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String pesel;

    public UpdateUserDto(Long id, String firstName, String lastName, String pesel) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.pesel = pesel;
    }
}
