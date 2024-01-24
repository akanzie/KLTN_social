package com.social.demo.component.appuser;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.social.demo.dto.AuthRequestDTO;

@Service
public class AppUserService implements UserDetailsService {

        @Autowired
        private AppUserRepository appUserRepository;
        @Autowired
        private PasswordEncoder encoder;
        @Autowired
        private ModelMapper modelMapper;

        @Override
        public UserDetails loadUserByUsername(String username)
                        throws UsernameNotFoundException {
                return appUserRepository.findByUsername(username)
                                .orElseThrow(() -> new UsernameNotFoundException(
                                                "User not found " + username));
        }

        public String signUpUser(AuthRequestDTO authRequestDTO) {
                AppUser appUser = modelMapper.map(authRequestDTO, AppUser.class);
                appUser.setAppUserRole(AppUserRole.USER);
                boolean userExists = appUserRepository
                                .findByUsername(appUser.getUsername())
                                .isPresent();

                if (userExists) {
                        // TODO check of attributes are the same and
                        // TODO if email not confirmed send confirmation email.

                        throw new IllegalStateException("email already taken");
                }

                String encodedPassword = encoder
                                .encode(appUser.getPassword());

                appUser.setPassword(encodedPassword);

                appUserRepository.save(appUser);
                return "User Added Successfully";

        }

}