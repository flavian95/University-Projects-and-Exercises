
#include <gtk/gtk.h>
#include <stdio.h>
#include <stdlib.h>
#include <sys/stat.h>
#include <sys/types.h>
#include <unistd.h>

char selected_folder[512] = "";

void load_css(const char *css_file)
{
    GtkCssProvider *provider = gtk_css_provider_new();
    GdkDisplay *display = gdk_display_get_default();
    GdkScreen *screen = gdk_display_get_default_screen(display);

    gtk_style_context_add_provider_for_screen(screen, GTK_STYLE_PROVIDER(provider),
                                              GTK_STYLE_PROVIDER_PRIORITY_USER);

    GError *error = NULL;
    gtk_css_provider_load_from_path(provider, css_file, &error);

    if (error)
    {
        g_warning("Error loading CSS file: %s", error->message);
        g_clear_error(&error);
    }

    g_object_unref(provider);
}

void get_permissions_explicit(const char *path, char *permissions_explicit)
{
    struct stat folder_stat;

    if (stat(path, &folder_stat) == -1)
    {
        perror("Error retrieving folder information");
        snprintf(permissions_explicit, 256, "Error");
        return;
    }

    char user[64], group[64], other[64];

    snprintf(user, sizeof(user), "User: %s %s %s",
             (folder_stat.st_mode & S_IRUSR) ? "Read" : "-",
             (folder_stat.st_mode & S_IWUSR) ? "Write" : "-",
             (folder_stat.st_mode & S_IXUSR) ? "Execute" : "-");

    snprintf(group, sizeof(group), "Group: %s %s %s",
             (folder_stat.st_mode & S_IRGRP) ? "Read" : "-",
             (folder_stat.st_mode & S_IWGRP) ? "Write" : "-",
             (folder_stat.st_mode & S_IXGRP) ? "Execute" : "-");

    snprintf(other, sizeof(other), "Other: %s %s %s",
             (folder_stat.st_mode & S_IROTH) ? "Read" : "-",
             (folder_stat.st_mode & S_IWOTH) ? "Write" : "-",
             (folder_stat.st_mode & S_IXOTH) ? "Execute" : "-");

    snprintf(permissions_explicit, 256, "%s\n%s\n%s", user, group, other);
}

static void on_button_clicked(GtkWidget *widget, gpointer data)
{
    mode_t mode = GPOINTER_TO_INT(data);

    if (chmod(selected_folder, mode) == -1)
    {
        perror("Failed to change folder permissions");
        return;
    }

    g_print("Changed folder permissions to %o\n", mode);

    GtkWidget *permissions_label = g_object_get_data(G_OBJECT(widget), "permissions_label");
    char permissions_explicit[256];
    get_permissions_explicit(selected_folder, permissions_explicit);

    gtk_label_set_text(GTK_LABEL(permissions_label), permissions_explicit);
}

static void on_folder_selected(GtkWidget *widget, gpointer data)
{
    const char *folder = (const char *)data;
    snprintf(selected_folder, sizeof(selected_folder), "%s", folder);

    GtkWidget *window = gtk_widget_get_toplevel(widget);

    GtkWidget *grid = gtk_grid_new();
    gtk_grid_set_row_spacing(GTK_GRID(grid), 10);
    gtk_grid_set_column_spacing(GTK_GRID(grid), 10);

    GtkWidget *permissions_label = gtk_label_new("Current Permissions: Not Retrieved");
    gtk_widget_set_name(permissions_label, "permissions_label");
    gtk_grid_attach(GTK_GRID(grid), permissions_label, 0, 0, 4, 1);

    GtkWidget *button_700 = gtk_button_new_with_label("Set permissions to\n User: Read Write Execute\n Group: - - -\n Other: - - -");
    g_signal_connect(button_700, "clicked", G_CALLBACK(on_button_clicked), GINT_TO_POINTER(0700));
    g_object_set_data(G_OBJECT(button_700), "permissions_label", permissions_label);
    gtk_grid_attach(GTK_GRID(grid), button_700, 0, 1, 1, 1);

    GtkWidget *button_710 = gtk_button_new_with_label("Set permissions to\n User: Read Write Execute\n Group: - - Execute\n Other: - - -");
    g_signal_connect(button_710, "clicked", G_CALLBACK(on_button_clicked), GINT_TO_POINTER(0710));
    g_object_set_data(G_OBJECT(button_710), "permissions_label", permissions_label);
    gtk_grid_attach(GTK_GRID(grid), button_710, 1, 1, 1, 1);

    GtkWidget *button_720 = gtk_button_new_with_label("Set permissions to\n User: Read Write Execute\n Group: - Write -\n Other: - - -");
    g_signal_connect(button_720, "clicked", G_CALLBACK(on_button_clicked), GINT_TO_POINTER(0720));
    g_object_set_data(G_OBJECT(button_720), "permissions_label", permissions_label);
    gtk_grid_attach(GTK_GRID(grid), button_720, 2, 1, 1, 1);

    GtkWidget *button_730 = gtk_button_new_with_label("Set permissions to\n User: Read Write Execute\n Group: - Write Execute\n Other: - - -");
    g_signal_connect(button_730, "clicked", G_CALLBACK(on_button_clicked), GINT_TO_POINTER(0730));
    g_object_set_data(G_OBJECT(button_730), "permissions_label", permissions_label);
    gtk_grid_attach(GTK_GRID(grid), button_730, 3, 1, 1, 1);

    GtkWidget *button_740 = gtk_button_new_with_label("Set permissions to\n User: Read Write Execute\n Group: Read - -\n Other: - - -");
    g_signal_connect(button_740, "clicked", G_CALLBACK(on_button_clicked), GINT_TO_POINTER(0740));
    g_object_set_data(G_OBJECT(button_740), "permissions_label", permissions_label);
    gtk_grid_attach(GTK_GRID(grid), button_740, 0, 2, 1, 1);

    GtkWidget *button_750 = gtk_button_new_with_label("Set permissions to\n User: Read Write Execute\n Group: Read - Execute\n Other: - - -");
    g_signal_connect(button_750, "clicked", G_CALLBACK(on_button_clicked), GINT_TO_POINTER(0750));
    g_object_set_data(G_OBJECT(button_750), "permissions_label", permissions_label);
    gtk_grid_attach(GTK_GRID(grid), button_750, 1, 2, 1, 1);

    GtkWidget *button_760 = gtk_button_new_with_label("Set permissions to\n User: Read Write Execute\n Group: Read Write -\n Other: - - -");
    g_signal_connect(button_760, "clicked", G_CALLBACK(on_button_clicked), GINT_TO_POINTER(0760));
    g_object_set_data(G_OBJECT(button_760), "permissions_label", permissions_label);
    gtk_grid_attach(GTK_GRID(grid), button_760, 2, 2, 1, 1);

    GtkWidget *button_770 = gtk_button_new_with_label("Set permissions to\n User: Read Write Execute\n Group: Read Write Execute\n Other: - - -");
    g_signal_connect(button_770, "clicked", G_CALLBACK(on_button_clicked), GINT_TO_POINTER(0770));
    g_object_set_data(G_OBJECT(button_770), "permissions_label", permissions_label);
    gtk_grid_attach(GTK_GRID(grid), button_770, 3, 2, 1, 1);

    GtkWidget *button_771 = gtk_button_new_with_label("Set permissions to\n User: Read Write Execute\n Group: Read Write Execute\n Other: - - Execute");
    g_signal_connect(button_771, "clicked", G_CALLBACK(on_button_clicked), GINT_TO_POINTER(0771));
    g_object_set_data(G_OBJECT(button_771), "permissions_label", permissions_label);
    gtk_grid_attach(GTK_GRID(grid), button_771, 0, 3, 1, 1);

    GtkWidget *button_772 = gtk_button_new_with_label("Set permissions to\n User: Read Write Execute\n Group: Read Write Execute\n Other: - Write -");
    g_signal_connect(button_772, "clicked", G_CALLBACK(on_button_clicked), GINT_TO_POINTER(0772));
    g_object_set_data(G_OBJECT(button_772), "permissions_label", permissions_label);
    gtk_grid_attach(GTK_GRID(grid), button_772, 1, 3, 1, 1);

    GtkWidget *button_773 = gtk_button_new_with_label("Set permissions to\n User: Read Write Execute\n Group: Read Write Execute\n Other: - Write Execute");
    g_signal_connect(button_773, "clicked", G_CALLBACK(on_button_clicked), GINT_TO_POINTER(0773));
    g_object_set_data(G_OBJECT(button_773), "permissions_label", permissions_label);
    gtk_grid_attach(GTK_GRID(grid), button_773, 2, 3, 1, 1);

    GtkWidget *button_774 = gtk_button_new_with_label("Set permissions to\n User: Read Write Execute\n Group: Read Write Execute\n Other: Read - -");
    g_signal_connect(button_774, "clicked", G_CALLBACK(on_button_clicked), GINT_TO_POINTER(0774));
    g_object_set_data(G_OBJECT(button_774), "permissions_label", permissions_label);
    gtk_grid_attach(GTK_GRID(grid), button_774, 3, 3, 1, 1);

    GtkWidget *button_775 = gtk_button_new_with_label("Set permissions to\n User: Read Write Execute\n Group: Read Write Execute\n Other: Read - Execute");
    g_signal_connect(button_775, "clicked", G_CALLBACK(on_button_clicked), GINT_TO_POINTER(0775));
    g_object_set_data(G_OBJECT(button_775), "permissions_label", permissions_label);
    gtk_grid_attach(GTK_GRID(grid), button_775, 0, 4, 1, 1);

    GtkWidget *button_776 = gtk_button_new_with_label("Set permissions to\n User: Read Write Execute\n Group: Read Write Execute\n Other: Read Write -");
    g_signal_connect(button_776, "clicked", G_CALLBACK(on_button_clicked), GINT_TO_POINTER(0776));
    g_object_set_data(G_OBJECT(button_776), "permissions_label", permissions_label);
    gtk_grid_attach(GTK_GRID(grid), button_776, 1, 4, 1, 1);

    GtkWidget *button_777 = gtk_button_new_with_label("Set permissions to\n User: Read Write Execute\n Group: Read Write Execute\n Other: Read Write Execute");
    g_signal_connect(button_777, "clicked", G_CALLBACK(on_button_clicked), GINT_TO_POINTER(0777));
    g_object_set_data(G_OBJECT(button_777), "permissions_label", permissions_label);
    gtk_grid_attach(GTK_GRID(grid), button_777, 2, 4, 1, 1);

    char permissions_explicit[256];
    get_permissions_explicit(selected_folder, permissions_explicit);
    gtk_label_set_text(GTK_LABEL(permissions_label), permissions_explicit);

    gtk_container_remove(GTK_CONTAINER(window), gtk_bin_get_child(GTK_BIN(window)));
    gtk_container_add(GTK_CONTAINER(window), grid);

    gtk_widget_show_all(window);
}

static void on_window_destroy(GtkWidget *widget, gpointer data)
{
    gtk_main_quit();
}

int main(int argc, char *argv[])
{
    gtk_init(&argc, &argv);
    const char *css_file = "style.css";
    load_css(css_file);

    GtkWidget *window = gtk_window_new(GTK_WINDOW_TOPLEVEL);
    gtk_window_set_title(GTK_WINDOW(window), "Select Folder");
    gtk_window_set_default_size(GTK_WINDOW(window), 400, 300);

    GtkWidget *grid = gtk_grid_new();
    gtk_grid_set_row_spacing(GTK_GRID(grid), 10);
    gtk_grid_set_column_spacing(GTK_GRID(grid), 10);

    GtkWidget *button_video1 = gtk_button_new_with_label("Edit Video1 Folder");
    GtkWidget *button_video2 = gtk_button_new_with_label("Edit Video2 Folder");
    GtkWidget *button_video3 = gtk_button_new_with_label("Edit Video3 Folder");
    GtkWidget *button_video4 = gtk_button_new_with_label("Edit Video4 Folder");

    const char *homeDir = getenv("HOME");
    if (homeDir == NULL)
    {
        perror("Failed to get HOME environment variable");
        return -1;
    }

    char video1_path[512], video2_path[512], video3_path[512], video4_path[512];
    snprintf(video1_path, sizeof(video1_path), "%s/Desktop/VideoEditing/Video1", homeDir);
    snprintf(video2_path, sizeof(video2_path), "%s/Desktop/VideoEditing/Video2", homeDir);
    snprintf(video3_path, sizeof(video3_path), "%s/Desktop/VideoEditing/Video3", homeDir);
    snprintf(video4_path, sizeof(video4_path), "%s/Desktop/VideoEditing/Video4", homeDir);

    g_signal_connect(button_video1, "clicked", G_CALLBACK(on_folder_selected), video1_path);
    g_signal_connect(button_video2, "clicked", G_CALLBACK(on_folder_selected), video2_path);
    g_signal_connect(button_video3, "clicked", G_CALLBACK(on_folder_selected), video3_path);
    g_signal_connect(button_video4, "clicked", G_CALLBACK(on_folder_selected), video4_path);

    gtk_grid_attach(GTK_GRID(grid), button_video1, 0, 0, 1, 1);
    gtk_grid_attach(GTK_GRID(grid), button_video2, 1, 0, 1, 1);
    gtk_grid_attach(GTK_GRID(grid), button_video3, 0, 1, 1, 1);
    gtk_grid_attach(GTK_GRID(grid), button_video4, 1, 1, 1, 1);

    gtk_container_add(GTK_CONTAINER(window), grid);

    g_signal_connect(window, "destroy", G_CALLBACK(on_window_destroy), NULL);

    gtk_widget_show_all(window);

    gtk_main();

    return 0;
}