document.addEventListener('DOMContentLoaded', function () {
    document.getElementById('nextPetLink').addEventListener('click', function (event) {
        event.preventDefault();
        const clientId = document.getElementById('clientId').value;

        fetch('viewBookings?clientId=' + clientId)
            .then(response => response.json())
            .then(data => {
                const selectElement = document.querySelector('.petlist');

                // Preserve existing options
                const existingOptions = Array.from(selectElement.options).map(option => option.value);

                // Append new options without clearing existing ones
                data.forEach(pet => {
                    if (!existingOptions.includes(pet.petId)) {
                        const option = document.createElement('option');
                        option.value = pet.petId;
                        option.textContent = `${pet.petId} : ${pet.petName}`;
                        selectElement.appendChild(option);
                    }
                });

                // Show the select pet section
                document.getElementById('selectPetSection').style.display = 'block';
            })
            .catch(error => console.error('Error:', error));
    });

    document.getElementById('nextDr').addEventListener('click', function (event) {
        event.preventDefault();

        fetch('viewStaffSchedule')
            .then(response => response.json())
            .then(data => {
                const selectElement = document.querySelector('.drList');

                // Preserve existing options
                const existingOptions = Array.from(selectElement.options).map(option => option.value);

                // Append new options without clearing existing ones
                data.forEach(staff => {
                    if (!existingOptions.includes(staff.sid)) {
                        const option = document.createElement('option');
                        option.value = staff.sid;
                        option.textContent = staff.name;
                        selectElement.appendChild(option);
                    }
                });

                // Show the select doctor section
                document.getElementById('selectDr').style.display = 'block';
            })
            .catch(error => console.error('Error:', error));
    });

    document.getElementById('nextAppt').addEventListener('click', function (event) {
        event.preventDefault();
        const staffId = document.getElementById('staffId').value;

        fetch('viewDatebyDr?staffId=' + staffId)
            .then(response => response.json())
            .then(data => {
                const selectElement = document.querySelector('.apptList');

                // Preserve existing options
                const existingOptions = Array.from(selectElement.options).map(option => option.value);

                // Append new options without clearing existing ones
                const currentDate = new Date();
                const upcomingSchedules = data.filter(schedule => {
                    const scheduleDate = new Date(schedule.date);
                    return scheduleDate >= currentDate;
                });

                if (upcomingSchedules.length === 0) {
                    const option = document.createElement('option');
                    option.value = '';
                    option.textContent = 'No available upcoming dates';
                    selectElement.appendChild(option);
                } else {
                    upcomingSchedules.forEach(schedule => {
                        if (!existingOptions.includes(schedule.scheduleId)) {
                            const option = document.createElement('option');
                            option.value = schedule.scheduleId;
                            option.textContent = `${schedule.date} - ${schedule.time}`;
                            selectElement.appendChild(option);
                        }
                    });
                }

                // Show the select date section
                document.getElementById('selectDate').style.display = 'block';
            })
            .catch(error => console.error('Error:', error));
    });

    document.getElementById('nextService').addEventListener('click', function (event) {
        event.preventDefault();

        fetch('viewServices')
            .then(response => response.json())
            .then(data => {
                const selectElement = document.querySelector('.servList');

                // Preserve existing options
                const existingOptions = Array.from(selectElement.options).map(option => option.value);

                // Append new options without clearing existing ones
                data.forEach(service => {
                    if (!existingOptions.includes(service.serviceId)) {
                        const option = document.createElement('option');
                        option.value = service.serviceId;
                        option.textContent = `${service.servType} - RM${service.servFee}`;
                        selectElement.appendChild(option);
                    }
                });

                // Show the select service section
                document.getElementById('selectService').style.display = 'block';
            })
            .catch(error => console.error('Error:', error));
    });
});
