document.getElementById('nextPetLink').addEventListener('click', function (event) {
    event.preventDefault();
    const clientId = document.getElementById('clientId').value;

    fetch('viewBookings?clientId=' + clientId)
        .then(response => response.json())
        .then(data => {
            const selectElement = document.querySelector('.petlist');

            // Append new options without clearing existing ones
            data.forEach(pet => {
                const option = document.createElement('option');
                option.value = pet.petId;
                option.textContent = `${pet.petId} : ${pet.petName}`;
                selectElement.appendChild(option);
            });

            // Show the select pet section
            document.getElementById('selectPetSection').style.display = 'block';
        })
        .catch(error => {
            console.error('Error:', error);
        });
});

document.getElementById('nextDr').addEventListener('click', function (event) {
    event.preventDefault();

    fetch('viewStaffSchedule')
        .then(response => response.json())
        .then(data => {
            const selectElement = document.querySelector('.drList');

            // Append new options without clearing existing ones
            data.forEach(staff => {
                const option = document.createElement('option');
                option.value = staff.sid;
                option.textContent = staff.name;
                selectElement.appendChild(option);
            });

            // Show the select doctor section
            document.getElementById('selectDr').style.display = 'block';
        })
        .catch(error => {
            console.error('Error:', error);
        });
});

document.getElementById('nextAppt').addEventListener('click', function (event) {
    event.preventDefault();
    const staffId = document.getElementById('staffId').value;

    fetch('viewDatebyDr?staffId=' + staffId)
        .then(response => response.json())
        .then(data => {
            const selectElement = document.querySelector('.apptList');

            // Clear previous options (if needed)
            selectElement.innerHTML = '';

            // Append new options
            const currentDate = new Date();
            const upcomingSchedules = data.filter(schedule => {
                const scheduleDate = new Date(schedule.date);
                return scheduleDate >= currentDate;
            });

            if (upcomingSchedules.length === 0) {
                const option = document.createElement('option');
                option.value = '';
                option.textContent = 'Not available upcoming dates';
                selectElement.appendChild(option);
            } else {
                upcomingSchedules.forEach(schedule => {
                    const option = document.createElement('option');
                    option.value = schedule.scheduleId;
                    option.textContent = `${schedule.date} - ${schedule.time}`;
                    selectElement.appendChild(option);
                });
            }

            // Show the select date section
            document.getElementById('selectDate').style.display = 'block';
        })
        .catch(error => {
            console.error('Error:', error);
        });
});

document.getElementById('nextService').addEventListener('click', function (event) {
    event.preventDefault();

    fetch('viewServices')
        .then(response => response.json())
        .then(data => {
            const selectElement = document.querySelector('.servList');

            // Append new options without clearing existing ones
            data.forEach(service => {
                const option = document.createElement('option');
                option.value = service.serviceId;
                option.textContent = `${service.servType} - RM${service.servFee}`;
                selectElement.appendChild(option);
            });

            // Show the select service section
            document.getElementById('selectService').style.display = 'block';
        })
        .catch(error => {
            console.error('Error:', error);
        });
});
