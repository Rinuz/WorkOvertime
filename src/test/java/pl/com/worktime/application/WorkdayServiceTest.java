package pl.com.worktime.application;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pl.com.worktime.WorktimeApplication;
import pl.com.worktime.domain.Workday;
import pl.com.worktime.domain.Worktime;
import pl.com.worktime.domain.repository.WorktimeRepository;

import javax.inject.Inject;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Radosław Kozdruń
 * 22.08.2017
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WorktimeApplication.class)
public class WorkdayServiceTest {

    @Inject
    private WorkdayService workdayService;
    @Inject
    private WorktimeRepository worktimeRepository;

    @Test
    public void shouldCreateWorkday() {
        //when
        Workday workday = workdayService.createWorkday();

        //then
        assertNotNull(workday);
        assertNotNull(workday.getAggregateId());
    }

    @Test
    public void shouldAddWorktimeToWorkday() {
        //given
        Workday workday = workdayService.createWorkday();
        LocalDateTime startOfWork = LocalDateTime.now().withHour(7);
        LocalDateTime endOfWork = LocalDateTime.now().withHour(12);

        //when
        Worktime worktime = workdayService.addWorktime(workday.getAggregateId(), startOfWork, endOfWork);

        //then
        assertNotNull(worktime);
        assertNotNull(worktime.getId());
        assertEquals(startOfWork, worktime.getWorkPeriod().getStartOfWork());
        assertEquals(endOfWork, worktime.getWorkPeriod().getEndOfWork());
    }

    @Test
    public void shouldRemoveWorktimeFromWorkday() {
        //given
        Workday workday = workdayService.createWorkday();
        Worktime worktime = workdayService.addWorktime(workday.getAggregateId(), LocalDateTime.now(), LocalDateTime.now());

        //when
        workdayService.removeWorktime(workday.getAggregateId(), worktime.getId());

        //then
        assertNull(worktimeRepository.load(worktime.getId()));
    }
}