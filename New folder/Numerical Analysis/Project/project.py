
import tkinter as tk
from tkinter import ttk
from tkinter import filedialog
import numpy as np
from scipy.integrate import quadrature
from scipy.misc import derivative

# Define the function to integrate
def my_fun(x, a, b, c):
    return (a + b * np.sin(x)) / (4 + c * np.exp(x ** 2))

# --------------------- Midpoint Rule ---------------------
def midpoint_rule(f, a, b, n, args=()):
    h = (b - a) / n
    total = 0
    for i in range(n):
        midpoint = a + h * (i + 0.5)
        total += f(midpoint, *args)
    return h * total

def compare_midpoint_methods(a_val, b_val, c_val, interval_start=0, interval_end=1, n_vals=[2, 4, 8, 16, 32]):
    output = "Midpoint Rule Comparison:\n"
    output += f"{'n':>3} | {'Midpoint':>10} | {'Quadrature':>12} | {'Abs Error':>10}\n"
    output += "-" * 44 + "\n"
    for n in n_vals:
        midpoint_result = midpoint_rule(my_fun, interval_start, interval_end, n, args=(a_val, b_val, c_val))
        quad_result, _ = quadrature(my_fun, interval_start, interval_end, args=(a_val, b_val, c_val))
        error = abs(midpoint_result - quad_result)
        output += f"{n:>3} | {midpoint_result:>10.6f} | {quad_result:>12.6f} | {error:>10.2e}\n"
    output += "\n"
    return output

# --------------------- Trapezoidal Rule ---------------------
def trapezoidal_rule(f, a, b, n, args=()):
    h = (b - a) / n
    result = 0.5 * f(a, *args) + 0.5 * f(b, *args) # f(a) / 2 + f(b) / 2
    for i in range(1, n):
        result += f(a + i * h, *args) # add integral of f(x i)
    return h * result #final * h

def estimate_trapezoidal_error(f, a, b, n, args=()):
    def f_second_derivative(x):
        return derivative(lambda x_: derivative(lambda x__: f(x__, *args), x_, dx=1e-6), x, dx=1e-6)

    sample_points = np.linspace(a, b, 1000)
    second_derivs = np.abs([f_second_derivative(x) for x in sample_points])
    max_f_double_prime = np.max(second_derivs)
    
    error_bound = ((b - a) ** 3 / (12 * n ** 2)) * max_f_double_prime
    return error_bound

def compare_trapezoidal_methods(a_val, b_val, c_val, interval_start=0, interval_end=1, n_vals=[2, 4, 8, 16, 32]):
    output = "Trapezoidal Rule Comparison:\n"
    output += f"{'n':>3} | {'Trapezoid':>10} | {'Quadrature':>12} | {'Abs Error':>10} | {'Est. Error':>10}\n"  #Width of each line
    output += "-" * 66 + "\n"  #Line divider
    for n in n_vals:
        trap_result = trapezoidal_rule(my_fun, interval_start, interval_end, n, args=(a_val, b_val, c_val))
        quad_result, _ = quadrature(my_fun, interval_start, interval_end, args=(a_val, b_val, c_val))
        abs_error = abs(trap_result - quad_result)
        est_error = estimate_trapezoidal_error(my_fun, interval_start, interval_end, n, args=(a_val, b_val, c_val))
        output += f"{n:>3} | {trap_result:>10.6f} | {quad_result:>12.6f} | {abs_error:>10.2e} | {est_error:>10.2e}\n"
    output += "\n"
    return output

# --------------------- Simpson's Rule ---------------------
def simpson_rule(f, a, b, n, args=()):
    if n % 2 != 0:
        n += 1  # Simpson's rule requires even n
    h = (b - a) / n
    result = f(a, *args) + f(b, *args)
    for i in range(1, n, 2):
        result += 4 * f(a + i * h, *args)
    for i in range(2, n-1, 2):
        result += 2 * f(a + i * h, *args)
    return h * result / 3

def estimate_simpson_error(f, a, b, n, args=()):
    if n % 2 != 0:
        n += 1
    def f_fourth_derivative(x):
        return derivative(lambda x_: derivative(lambda x__: derivative(lambda x___: derivative(lambda x____: f(x____, *args), x___, dx=1e-6), x__, dx=1e-6), x_, dx=1e-6), x, dx=1e-6)

    sample_points = np.linspace(a, b, 500)
    fourth_derivs = np.abs([f_fourth_derivative(x) for x in sample_points])
    max_f_fourth = np.max(fourth_derivs)

    error_bound = ((b - a) ** 5 / (180 * n ** 4)) * max_f_fourth
    return error_bound

def compare_simpson_methods(a_val, b_val, c_val, interval_start=0, interval_end=1, n_vals=[2, 4, 8, 16, 32]):
    output = "Simpson's Rule Comparison:\n"
    output += f"{'n':>3} | {'Simpson':>10} | {'Quadrature':>12} | {'Abs Error':>10} | {'Est. Error':>10}\n"
    output += "-" * 66 + "\n"
    for n in n_vals:
        simpson_result = simpson_rule(my_fun, interval_start, interval_end, n, args=(a_val, b_val, c_val))
        quad_result, _ = quadrature(my_fun, interval_start, interval_end, args=(a_val, b_val, c_val))
        abs_error = abs(simpson_result - quad_result)
        est_error = estimate_simpson_error(my_fun, interval_start, interval_end, n, args=(a_val, b_val, c_val))
        output += f"{n:>3} | {simpson_result:>10.6f} | {quad_result:>12.6f} | {abs_error:>10.2e} | {est_error:>10.2e}\n"
    output += "\n"
    return output

# --------------------- GUI ---------------------

def create_gui():
    def on_calculate():
        try:
            a = int(entry_a.get())
            b = int(entry_b.get())
            c = int(entry_c.get())
            result = ""
            result += compare_midpoint_methods(a, b, c)
            result += compare_trapezoidal_methods(a, b, c)
            result += compare_simpson_methods(a, b, c)
            text_output.delete(1.0, tk.END)
            text_output.insert(tk.END, result)
        except ValueError:
            text_output.delete(1.0, tk.END)
            text_output.insert(tk.END, "Please enter *integer* values for a, b, and c.")

    def on_save():
        file_path = filedialog.asksaveasfilename(
            defaultextension=".txt",
            filetypes=[("Text files", "*.txt")],
            title="Save results as"
        )
        if file_path:
            try:
                with open(file_path, "w") as file:
                    file.write(text_output.get(1.0, tk.END))
            except Exception as e:
                text_output.insert(tk.END, f"\nError saving file: {e}\n")

    def on_help():
        help_text = """
This program demonstrates **three numerical integration methods**:

1️⃣ **Midpoint Rule**  
   - Divides the interval into 'n' subintervals.
   - Approximates area using rectangles evaluated at each subinterval midpoint.

2️⃣ **Trapezoidal Rule**  
   - Divides the interval into 'n' subintervals.
   - Approximates area using trapezoids (linear interpolation between points).
   - Also estimates the theoretical error bound.

3️⃣ **Simpson's Rule**  
   - Divides the interval into 'n' even subintervals.
   - Approximates area using parabolic arcs.
   - Also estimates the theoretical error bound.

✨ The function being integrated is:  
    (a + b * sin(x)) / (4 + c * exp(x²))

👩‍💻 **How to use the GUI:**  
- Enter values for **a**, **b**, and **c** (must be integers).  
- Click **Calculate** to compute and display the results.
- You will see a comparison of your result vs. a high-precision reference (Quadrature).
- Click **Save Results** to export the output as a `.txt` file.
- Click **Help** (this button) to display this explanation.

📏 **Comparison tables:**  
- For each method, results are shown for multiple 'n' values (number of subintervals).
- The **Absolute Error** shows how far the method result is from the high-precision result.
- The **Estimated Error** (for Trapezoidal & Simpson) shows an expected theoretical bound.

Enjoy exploring numerical integration!
"""
        help_window = tk.Toplevel(root)
        help_window.title("Help - Program Explanation")
        help_text_widget = tk.Text(help_window, width=100, height=40, wrap=tk.WORD)
        help_text_widget.insert(tk.END, help_text)
        help_text_widget.config(state=tk.DISABLED) #No edit
        help_text_widget.pack(padx=10, pady=10)

    def validate_integer_input(new_value):
        if new_value == "":
            return True
        try:
            int(new_value)
            return True
        except ValueError:
            return False

    root = tk.Tk()
    root.title("Numerical Integration: Midpoint, Trapezoidal, Simpson")

    vcmd = (root.register(validate_integer_input), "%P")

    ttk.Label(root, text="Enter a:").grid(row=0, column=0, padx=5, pady=5)
    entry_a = ttk.Entry(root, validate="key", validatecommand=vcmd)
    entry_a.grid(row=0, column=1, padx=5, pady=5)

    ttk.Label(root, text="Enter b:").grid(row=1, column=0, padx=5, pady=5)
    entry_b = ttk.Entry(root, validate="key", validatecommand=vcmd)
    entry_b.grid(row=1, column=1, padx=5, pady=5)

    ttk.Label(root, text="Enter c:").grid(row=2, column=0, padx=5, pady=5)
    entry_c = ttk.Entry(root, validate="key", validatecommand=vcmd)
    entry_c.grid(row=2, column=1, padx=5, pady=5)

    calculate_button = ttk.Button(root, text="Calculate", command=on_calculate)
    calculate_button.grid(row=3, column=0, columnspan=2, pady=5)

    save_button = ttk.Button(root, text="Save Results", command=on_save)
    save_button.grid(row=4, column=0, columnspan=2, pady=5)

    help_button = ttk.Button(root, text="Help", command=on_help)
    help_button.grid(row=5, column=0, columnspan=2, pady=5)

    text_output = tk.Text(root, width=100, height=35, font=("Courier", 10))
    text_output.grid(row=6, column=0, columnspan=2, padx=10, pady=10)

    root.mainloop()

create_gui()















































# import tkinter as tk
# from tkinter import ttk
# import numpy as np
# from scipy.integrate import quadrature

# # Define the function to integrate
# def my_fun(x, a, b, c):
#     return (a + b * np.sin(x)) / (4 + c * np.exp(x ** 2))

# # Midpoint Rule Implementation
# def midpoint_rule(f, a, b, n, args=()):
#     h = (b - a) / n
#     total = 0
#     for i in range(n):
#         midpoint = a + h * (i + 0.5)
#         total += f(midpoint, *args)
#     return h * total

# # Compare methods and return results as string
# def compare_methods(a_val, b_val, c_val, interval_start=0, interval_end=1, n_vals=[2, 4, 8, 16, 32]):
#     output = f"{'n':>3} | {'Midpoint':>10} | {'Quadrature':>12} | {'Abs Error':>10}\n"
#     output += "-" * 44 + "\n"
#     for n in n_vals:
#         midpoint_result = midpoint_rule(my_fun, interval_start, interval_end, n, args=(a_val, b_val, c_val))
#         quad_result, _ = quadrature(my_fun, interval_start, interval_end, args=(a_val, b_val, c_val))
#         error = abs(midpoint_result - quad_result)
#         output += f"{n:>3} | {midpoint_result:>10.6f} | {quad_result:>12.6f} | {error:>10.2e}\n"
#     return output

# # GUI application
# def create_gui():
#     def on_calculate():
#         try:
#             a = float(entry_a.get())
#             b = float(entry_b.get())
#             c = float(entry_c.get())
#             result = compare_methods(a, b, c)
#             text_output.delete(1.0, tk.END)
#             text_output.insert(tk.END, result)
#         except ValueError:
#             text_output.delete(1.0, tk.END)
#             text_output.insert(tk.END, "Please enter valid numeric values for a, b, and c.")

#     root = tk.Tk()
#     root.title("Midpoint vs Quadrature Comparison")

#     ttk.Label(root, text="Enter a:").grid(row=0, column=0, padx=5, pady=5)
#     entry_a = ttk.Entry(root)
#     entry_a.grid(row=0, column=1, padx=5, pady=5)

#     ttk.Label(root, text="Enter b:").grid(row=1, column=0, padx=5, pady=5)
#     entry_b = ttk.Entry(root)
#     entry_b.grid(row=1, column=1, padx=5, pady=5)

#     ttk.Label(root, text="Enter c:").grid(row=2, column=0, padx=5, pady=5)
#     entry_c = ttk.Entry(root)
#     entry_c.grid(row=2, column=1, padx=5, pady=5)

#     calculate_button = ttk.Button(root, text="Calculate", command=on_calculate)
#     calculate_button.grid(row=3, column=0, columnspan=2, pady=10)

#     text_output = tk.Text(root, width=60, height=15, font=("Courier", 10))
#     text_output.grid(row=4, column=0, columnspan=2, padx=10, pady=10)

#     root.mainloop()

# # Run the GUI
# create_gui()