//package com.cheese.oauth2authorizationserver.service;
//
//
//import com.cheese.core.constants.CustomExceptionCode;
//import com.cheese.core.domain.admin.Admin;
//import com.cheese.core.domain.admin.AdminRepository;
//import com.cheese.core.domain.adminRole.AdminRole;
//import com.cheese.core.domain.adminRole.AdminRoleRepository;
//import com.cheese.core.domain.enums.EAdminRole;
//import com.cheese.core.dto.request.SignupRequest;
//import com.cheese.core.dto.response.BaseResponse;
//import com.cheese.core.exception.CustomException;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.HashSet;
//import java.util.Set;
//
//@Service
//public class AdminDetailsServiceImpl implements UserDetailsService {
//
//    @Autowired
//    AdminRepository adminRepository;
//
//    @Autowired
//    AdminRoleRepository adminRoleRepository;
//
//    @Transactional
//    @Override
//    public AdminDetailsImpl loadUserByUsername(String username) throws UsernameNotFoundException {
//        Admin admin = adminRepository.findByUsername(username);
//        if (admin == null) {
//            throw new UsernameNotFoundException("Admin " + username + " can not be found");
//        }
//
//        return AdminDetailsImpl.build(admin);
//    }
//
//    @Transactional
//    public BaseResponse save(SignupRequest payload) throws UsernameNotFoundException {
//        if (adminRepository.existsByEmail(payload.getEmail()))
//            throw new CustomException(CustomExceptionCode.EMAIL_IS_EXIST);
//
//        if (adminRepository.existsByUsername(payload.getUsername()))
//            throw new CustomException(CustomExceptionCode.USERNAME_IS_EXIST);
//
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        Admin user = Admin.builder()
//                .email(payload.getEmail())
//                .username(payload.getUsername())
//                .password(encoder.encode(payload.getPassword()))
//                .build();
//
//        adminRepository.save(user);
//
//        Set<String> strRoles = payload.getRoles();
//        Set<AdminRole> roles = new HashSet<>();
//        if (strRoles == null){
//            AdminRole userRole = adminRoleRepository.findByName(EAdminRole.ROLE_ADMIN_READ).get();
//
//            if(userRole==null)
//                throw new CustomException(CustomExceptionCode.REQUEST_ROLE_NOT_FOUND);
//
//            roles.add(userRole);
//
//        } else {
//            for (String role: strRoles){
//                switch (role) {
//                    case "ADMIN":
//                        AdminRole adminRole = adminRoleRepository.findByName(EAdminRole.ROLE_ADMIN).get();
//
//                        if(adminRole==null){
//                            throw new CustomException(CustomExceptionCode.REQUEST_ROLE_NOT_FOUND);
//                        }
//                        roles.add(adminRole);
//
//                        break;
//                    case "READ":
//                        AdminRole managerRole = adminRoleRepository.findByName(EAdminRole.ROLE_ADMIN_READ).get();
//
//                        if(managerRole==null){
//                            throw new CustomException(CustomExceptionCode.REQUEST_ROLE_NOT_FOUND);
//                        }
//                        roles.add(managerRole);
//
//                        break;
//                    default:
//                        AdminRole userRole = adminRoleRepository.findByName(EAdminRole.ROLE_ADMIN_CUSTOM).get();
//
//                        if(userRole==null){
//                            throw new CustomException(CustomExceptionCode.REQUEST_ROLE_NOT_FOUND);
//                        }
//
//                        roles.add(userRole);
//
//                }
//            }
//        }
//
//        user.setAdminRoles(roles);
//        adminRepository.save(user);
//
//        return new BaseResponse(true, "OK");
//
//    }
//}
