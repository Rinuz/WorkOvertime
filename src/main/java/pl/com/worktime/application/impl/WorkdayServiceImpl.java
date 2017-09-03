package pl.com.worktime.application.impl;

import pl.com.worktime.application.WorkdayService;
import pl.com.worktime.application.annotation.ApplicationService;
import pl.com.worktime.application.dto.OvertimeDto;
import pl.com.worktime.application.dto.WorkdayDto;
import pl.com.worktime.application.dto.WorktimeDto;
import pl.com.worktime.domain.*;
import pl.com.worktime.domain.factory.WorkdayFactory;
import pl.com.worktime.domain.factory.WorktimeFactory;
import pl.com.worktime.domain.repository.UserRepository;
import pl.com.worktime.domain.repository.WorkdayRepository;
import pl.com.worktime.domain.repository.WorktimeRepository;
import pl.com.worktime.domain.support.AggregateId;

import javax.inject.Inject;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Sets.newHashSet;

@ApplicationService
public class WorkdayServiceImpl implements WorkdayService {

    @Inject
    private WorkdayFactory workdayFactory;
    @Inject
    private WorkdayRepository workdayRepository;
    @Inject
    private UserRepository userRepository;
    @Inject
    private WorktimeFactory worktimeFactory;
    @Inject
    private WorktimeRepository worktimeRepository;

    @Override
    public Workday createWorkday() {
        Workday workday = workdayFactory.createWorkday(LocalDate.now(), user());
        return workdayRepository.save(workday);
    }

    @Override
    public Worktime addWorktime(AggregateId workdayId, LocalDateTime startOfWork, LocalDateTime endOfWork) {
        Workday workday = workdayRepository.load(workdayId);
        Worktime worktime = worktimeFactory.createWorktime(startOfWork, endOfWork, workday, user());
        workday.addWorktime(worktime);
        return worktimeRepository.save(worktime);
    }

    @Override
    public void removeWorktime(AggregateId workdayId, Long worktimeId) {
        Workday workday = workdayRepository.load(workdayId);
        Worktime worktime = worktimeRepository.load(worktimeId);
        workday.removeWorktime(worktime);
        worktimeRepository.delete(worktime);
    }

    @Override
    public Overtime addOvertime(AggregateId workdayId, LocalDateTime startOfOvertime, LocalDateTime endOfOvertime) {
        return null;
    }

    @Override
    public void removeOvertime(AggregateId workdayId, Long worktimeId) {
    }

    @Override
    public List<WorkdayDto> getWorkdays(LocalDate month) {
        LocalDate firstDayOfMonth = month.withDayOfMonth(1);

        List<WorkdayDto> workdays = new ArrayList<>();
        workdays.add(workday(firstDayOfMonth.plusDays(0), 8, 16, null, null, PresenceType.PRESENT)); //pon
        workdays.add(workday(firstDayOfMonth.plusDays(1), 8, 16, null, null, PresenceType.PRESENT)); //wtorek
        workdays.add(workday(firstDayOfMonth.plusDays(2), 8, 16, 20, 21, PresenceType.PRESENT)); //sroda
        workdays.add(workday(firstDayOfMonth.plusDays(3), 8, 16, null, null, PresenceType.PRESENT)); //czwartek
        workdays.add(workday(firstDayOfMonth.plusDays(4), 8, 16, null, null, PresenceType.PRESENT)); //piatek
        workdays.add(workday(firstDayOfMonth.plusDays(5), null, null, 12, 15, PresenceType.HOLIDAY)); //sobota
        //---------------------------------------------------------------------------------------------------------------------- //niedziela
        workdays.add(workday(firstDayOfMonth.plusDays(7), 8, 16, null, null, PresenceType.PRESENT));//poniedzialek
        workdays.add(workday(firstDayOfMonth.plusDays(8), 8, 16, null, null, PresenceType.PRESENT)); //wtorek
        workdays.add(workday(firstDayOfMonth.plusDays(8), 8, 16, 20, 22, PresenceType.PRESENT)); //sroda
        workdays.add(workday(firstDayOfMonth.plusDays(9), 8, 16, null, null, PresenceType.PRESENT)); //czwartek
        workdays.add(workday(firstDayOfMonth.plusDays(10), 8, 16, null, null, PresenceType.PRESENT));//piatek
        workdays.add(workday(firstDayOfMonth.plusDays(1), 8, 16, null, null, PresenceType.PRESENT)); //poniedzialek
        workdays.add(workday(firstDayOfMonth.plusDays(1), 8, 16, 17, 21, PresenceType.PRESENT)); //wtorek


        return workdays;
    }

    private User user() {
        return userRepository.load(1L);
    }

    private static WorkdayDto workday(LocalDate date, Integer startWorktime, Integer endWorktime, Integer startOvertime, Integer endOvertime, PresenceType presenceType) {
        WorkdayDto workdayDto = new WorkdayDto();
        workdayDto.setDay(date);
        workdayDto.setPresenceType(presenceType);
        if (startWorktime != null && endWorktime != null) {
            WorktimeDto worktime = new WorktimeDto();
            worktime.setStartOfWork(date.atTime(startWorktime, 0, 0));
            worktime.setEndOfWork(date.atTime(endWorktime, 0, 0));
            workdayDto.setWorktimes(newHashSet(worktime));
        }

        if (startOvertime != null && endOvertime != null) {
            OvertimeDto overtime = new OvertimeDto();
            overtime.setStartOfWork(date.atTime(startOvertime, 0, 0));
            overtime.setEndOfWork(date.atTime(endOvertime, 0, 0));
            workdayDto.setOvertimes(newHashSet(overtime));
        }
        return workdayDto;
    }
}
