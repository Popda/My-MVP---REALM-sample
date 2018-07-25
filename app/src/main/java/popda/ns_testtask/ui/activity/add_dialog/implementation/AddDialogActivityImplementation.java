package popda.ns_testtask.ui.activity.add_dialog.implementation;

import android.support.v4.app.FragmentActivity;

import com.wdullaer.materialdatetimepicker.date.DatePickerDialog;
import com.wdullaer.materialdatetimepicker.time.TimePickerDialog;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import java.util.Calendar;

import popda.ns_testtask.core.model.NoteModel;
import popda.ns_testtask.ui.activity.add_dialog.presenter.AddDialogActivityPresenter;
import popda.ns_testtask.ui.activity.add_dialog.view.AddDialogActivityView;
import popda.ns_testtask.ui.activity.base.implementation.BaseImplementation;

public class AddDialogActivityImplementation extends BaseImplementation<AddDialogActivityView> implements AddDialogActivityPresenter {
    private LocalDate date = LocalDate.now();
    private LocalTime time = LocalTime.now();

    @Override
    public void saveData() {
        NoteModel noteModel = new NoteModel();
        DateTime dateTime = date.toLocalDateTime(time).toDateTime();
        noteModel.setTime(dateTime.getMillis());
        noteModel.setText(view.getComment());

        noteModel.save();

        view.finish();
    }

    @Override
    public void pickDate() {
        DatePickerDialog dpd = DatePickerDialog.newInstance(
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePickerDialog datePickerDialog, int year, int monthOfYear, int dayOfMonth) {
                        date = date.withYear(year).withMonthOfYear(monthOfYear + 1).withDayOfMonth(dayOfMonth);
                        view.onDatePicked(date.toString());
                    }
                },
                date.getYear(),
                date.getMonthOfYear() - 1,
                date.getDayOfMonth() -1
        );

        dpd.setMinDate(Calendar.getInstance());

        dpd.show(((FragmentActivity) view.getContext()).getFragmentManager(), "Datepickerdialog");
    }

    @Override
    public void pickTime() {
        TimePickerDialog dpd = TimePickerDialog.newInstance(
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePickerDialog timePickerDialog, int hourOfDay, int minute, int second) {
                        time = time.withHourOfDay(hourOfDay).withMinuteOfHour(minute).withSecondOfMinute(second);
                        view.onTimePicked(time.toString());
                    }
                },
                time.getHourOfDay(),
                time.getMinuteOfHour(),
                true
        );
        dpd.setMinTime(LocalTime.now().getHourOfDay(), LocalTime.now().getMinuteOfHour(), LocalTime.now().getSecondOfMinute());

        dpd.show(((FragmentActivity) view.getContext()).getFragmentManager(), "Datepickerdialog");
    }

}
