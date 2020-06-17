package com.example.demo.service;

import com.example.demo.dto.SignUpDto;
import com.example.demo.dto.SkillDto;
import com.example.demo.models.Skill;
import com.example.demo.models.User;
import com.example.demo.repositories.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.jws.soap.SOAPBinding;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Component
public class SkillServiceImpl implements SkillService {

    @Autowired
    private SkillRepository skillRepository;

    @Override
    public List<SkillDto> getSkillOfUser(User user) {
        return SkillDto.from(skillRepository.findAllByUser(user));
    }

    @Override
    public void save(SkillDto skillDto) {
        Skill skill = Skill.builder()
                .skill_name(skillDto.getSkill_name())
                .user(skillDto.getUser())
                .build();

        skillRepository.save(skill);

    }

    @Override
    public String[] getSkills(SkillDto skillDto) {
        String skillsName = skillDto.getSkill_name();
        String[] strings =  skillsName.split(", ");
        return strings;
    }

    @Override
    public void saveAll(ArrayList<SkillDto> skills) {
        ArrayList<Skill> skills1 = new ArrayList<>();
        for (int i = 0; i < skills.size(); i++){
            Skill skill = Skill.builder()
                    .skill_name(skills.get(i).getSkill_name())
                    .user(skills.get(i).getUser())
                    .build();
            skills1.add(skill);
        }
    }

    @Override
    public Skill findSkillById(Long id) {
        return skillRepository.getSkillById(id);
    }

//    @Override
//    public Skill findUserById(Long id) {
//        return skillRepository.;
//    }


//    @Override
//    public List<SkillDto> findSkill(String skill_name) {
//        return SkillDto.from(skillRepository.findAllBySkill_name(skill_name));
//    }

}
