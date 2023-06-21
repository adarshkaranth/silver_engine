function validateForm() {
        var firstName = document.getElementById('firstName').value;
        
        // Perform validation checks
        if (firstName === '') {
        	alert('first Name is required');
            return false; // Prevent form submission
        }

        // Additional validation logic goes here

        return true; // Allow form submission
    }