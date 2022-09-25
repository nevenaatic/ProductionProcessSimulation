package com.example.demo.service.failure;

import com.example.demo.dto.failures.FailuresPreviewDto;
import com.example.demo.model.failure.Failure;
import com.example.demo.model.failure.FailureInProcessStep;
import com.example.demo.model.users.User;
import com.example.demo.repository.failure.FailureRepository;
import org.springframework.core.io.FileUrlResource;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FailureService {

    private FailureRepository failureRepository;

    private FailureInProcessStepService failureIPSService;

    public FailureService(FailureRepository failureRepository){
        this.failureRepository = failureRepository;
    }

    public List<Failure> getAll(){
        return failureRepository.findAll();
    }

    public Failure save(Failure failure) {
        return this.failureRepository.save(failure);
    }

    public List<Failure> getWithFPS(){
        List<Failure> ret = new ArrayList<>();
        for(Failure f: getAll()){
            ret.add(failureRepository.getWithFPSList(f.getId()));
        }
        return ret;
    }

    public List<FailuresPreviewDto> getFailuresWithStepInformation(){
        List<FailuresPreviewDto> ret = new ArrayList<>();
        for(Failure f: getWithFPS()){
            FailuresPreviewDto failuresPreviewDto = new FailuresPreviewDto(f, "");
            String steps = "";
            if(f.getFailureInPSList().size() > 0){
                for(FailureInProcessStep fs: f.getFailureInPSList()){
                    steps = steps + fs.getProcessStep().getName() + "; ";
                }
            }
            failuresPreviewDto.steps = steps;
            ret.add(failuresPreviewDto);
        }
        return ret;
    }
}
