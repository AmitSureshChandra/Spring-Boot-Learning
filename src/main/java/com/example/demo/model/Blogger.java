package com.example.demo.model;

import javax.persistence.*;

import org.springframework.lang.NonNull;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("serial")
@Entity
@Table(name = "bloggers")
@Data
//@Getter
//@Setter
public class Blogger{
//	@Getter @Setter 
	@Id    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

//	comment

//    @NonNull
//    @Getter @Setter
    private String name;
    
//    @Getter @Setter
//    @NonNull
    private String email;
    
//    @Getter @Setter
//    @NonNull
    private String address;


//    @Getter @Setter 
    @OneToMany(mappedBy = "blogger")
    private List<Post> posts = new ArrayList<>();
}