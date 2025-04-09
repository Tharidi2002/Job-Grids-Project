package lk.ijse.backend.service.imple;


import jakarta.servlet.annotation.MultipartConfig;


import lk.ijse.backend.dto.UserDTO;

import lk.ijse.backend.entity.User;

import lk.ijse.backend.repository.UserRepo;
import lk.ijse.backend.service.UserService;
import lk.ijse.backend.util.JwtUtil;
import lk.ijse.backend.util.VarList;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.Set;

@Service
@Transactional
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024 * 2, // 2MB
        maxFileSize = 1024 * 1024 * 10, // 10MB
        maxRequestSize = 1024 * 1024 * 50 // 50MB
)
public class UserServiceImpl implements UserDetailsService, UserService {

    @Autowired
    private UserRepo userRepository;

   @Autowired
    private ModelMapper modelMapper;

   @Autowired
   private JwtUtil jwtUtil;

   private static final String FRONTEND_DIR = "static/images/";
   private static final String ITEMS = "items/";
   private static final String PROFILE = "profileImages/";
    private static final String DEFAULT_DIRECTORY = "/home/dilini/Documents/IJSE-Institute of Software Engineering/2nd Semester/AAD/Spring/Guppy-Zone-Aquarium-Project-New/Front-End/static/";
    private static final String DEFAULT_IMAGE_DIRECTORY = DEFAULT_DIRECTORY + "images/";
    private static final String ITEM_UPLOAD_DIR = DEFAULT_IMAGE_DIRECTORY + ITEMS;
    private static final String PROFILE_UPLOAD_DIR = DEFAULT_IMAGE_DIRECTORY + PROFILE;

    static {
        createIfNotExistDirectory(ITEM_UPLOAD_DIR);
        createIfNotExistDirectory(PROFILE_UPLOAD_DIR);
    }





    @Override
    public UserDTO getUserDTOByToken(String token) {
        String username = jwtUtil.getUsernameFromToken(token);
        return getUserByEmail(username);
    }

    public String saveImage(MultipartFile image, String savingDir, String savedFolderName) {
        String fileName = System.currentTimeMillis() + "_" + image.getOriginalFilename();
        Path filePath = Paths.get(savingDir + fileName);

        try {
            image.transferTo(filePath.toFile());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return savedFolderName + fileName;
    }
    static void createIfNotExistDirectory(String directory) {
        File uploadDir = new File(directory);
        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
    }

//    @Override
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userRepository.findByEmail(email);
//        System.out.println("user = " + user);
//
//        return new org.springframework.security.core.userdetails.User(
//                user.getEmail(),
//                user.getPassword(),
//                new ArrayList<>()
//        );
//    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email);

        if (user == null) {
            throw new UsernameNotFoundException("User not found for email: " + email);
        }

//        // Convert String role to GrantedAuthority
//        List<GrantedAuthority> authorities = new ArrayList<>();
//
//        if (user.getRole() != null && !user.getRole().isEmpty()) {
//            // If role is stored as "ROLE_SELLER", remove "ROLE_" prefix
//            String authority = user.getRole().startsWith("ROLE_")
//                    ? user.getRole().substring(5)  // Removes "ROLE_"
//                    : user.getRole();
//
//            authorities.add(new SimpleGrantedAuthority(authority));
//        }

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),
                user.getPassword(),
                getAuthority(user)
        );
    }

    public UserDTO loadUserDetailsByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(username);
        return modelMapper.map(user,UserDTO.class);
    }
//    public ProfileDTO loadProfileDetailsByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByEmail(username);
//        return modelMapper.map(user,ProfileDTO.class);
//    }



    private Set<SimpleGrantedAuthority> getAuthority(User user) {
        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority(user.getRole()));
        return authorities;
    }

    @Override
    public UserDTO getCurrentUser(String email) {
        if (userRepository.existsByEmail(email)) {
            User user=userRepository.findByEmail(email);
            return modelMapper.map(user,UserDTO.class);
        } else {
            return null;
        }
    }

    @Override
    public int updateUser(UserDTO userDTO) {
        if (!userRepository.existsByEmail(userDTO.getEmail())) {
            return VarList.Not_Found;
        } else {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
            userRepository.save(modelMapper.map(userDTO, User.class));
            return VarList.Created;
        }
    }

    @Override
    public UserDTO getUserEmailByToken(String token) {
        return null;
    }

    public UserDTO getUserByEmail(String email) {
        User user = userRepository.findByEmail(email);
        return modelMapper.map(user, UserDTO.class);
    }



    @Override
    public int saveUser(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            return VarList.Not_Acceptable;
        } else {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            userDTO.setPassword(passwordEncoder.encode(userDTO.getPassword()));
//            userDTO.setRole("USER");
            userRepository.save(modelMapper.map(userDTO, User.class));
            return VarList.Created;
        }

    }


    // File storage method
    private String saveFile(MultipartFile file) {
        if (file == null || file.isEmpty()) {
            return null; // Return null if no file is uploaded
        }

        String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
        Path filePath = Paths.get("uploads/profile_images/", fileName);

        try {
            Files.createDirectories(filePath.getParent()); // Ensure directory exists
            file.transferTo(filePath.toFile()); // Save file
        } catch (IOException e) {
            throw new RuntimeException("Failed to save file: " + fileName, e);
        }

        return fileName; // Return only the file name, not full path
    }




}
