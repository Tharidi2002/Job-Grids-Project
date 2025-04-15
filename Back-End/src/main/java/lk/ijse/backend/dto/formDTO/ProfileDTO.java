package lk.ijse.backend.dto.formDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.springframework.stereotype.Component;
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Component
public class ProfileDTO {
    @Email(message = "Invalid Format")
    private String email;
    private String image;

    // Remove the 'name' field and use separate first/last name fields
    private String firstName;
    private String lastName;

    @Size(min = 5,max = 30,message = "Name min length is 5")
    private String address;

    @Pattern(regexp = "^[0-9]{10}$",message = "Phone number must be 10 digits")
    private String contact;

    private String joinDate;

}
